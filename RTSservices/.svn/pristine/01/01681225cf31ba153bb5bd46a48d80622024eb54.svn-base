package com.mars.common.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.EntityMode;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.event.PostDeleteEvent;
import org.hibernate.event.PostDeleteEventListener;
import org.hibernate.event.PostInsertEvent;
import org.hibernate.event.PostInsertEventListener;
import org.hibernate.event.PostUpdateEvent;
import org.hibernate.event.PostUpdateEventListener;
import org.hibernate.event.def.DefaultSaveOrUpdateEventListener;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.mars.common.model.Dictionary;

/**
 * Audit Log Listener is used to log insert, update, Complete list of
 * listeners/events.
 * 
 * @see org.hibernate.event.EventListeners
 */
public final class AuditTrailHibernateListener extends DefaultSaveOrUpdateEventListener implements PostDeleteEventListener, PostUpdateEventListener, PostInsertEventListener {
	private static final long serialVersionUID = 1L;

	private static Log log = LogFactory.getLog(AuditTrailHibernateListener.class);

	public static final String OPERATION_TYPE_INSERT = "INSERT";

	public static final String OPERATION_TYPE_UPDATE = "UPDATE";

	public static final String OPERATION_TYPE_DELETE = "DELETE";

	public static boolean auditTrailenabled = false;

	public static boolean auditSaveenabled = false;

	public static boolean dictionaryEnabled = false;

	private static final String dictionaryLanguageCode = "mr";

	public void onPostDelete(PostDeleteEvent event) {
		if (!auditTrailenabled) {
			return;
		}
		try {

			final Serializable entityId = event.getPersister().hasIdentifierProperty() ? event.getPersister().getIdentifier(event.getEntity(), event.getPersister().guessEntityMode(event.getEntity()))
					: null;
			final String entityName = event.getEntity().getClass().getSimpleName();
			final String transDate = CommonUtils.getCurrentStringUIDate();
			if (!event.getEntity().getClass().getPackage().getName().startsWith("org.jbpm") && !entityName.equalsIgnoreCase("AuditTrail")) {
				final String userName = getUserName();
				// need to have a separate session for audit save
				Session session = event.getPersister().getFactory().openSession();
				session.beginTransaction();
				ArrayList<AuditTrail> auditTrailQueryList = new ArrayList<AuditTrail>();
				if (log.isDebugEnabled()) {
					log.debug("{} for: {}, ID: {}, actor: {}, date: {}" + new Object[] { entityName, entityId, userName, transDate });
				}

				// Creating AuditTrail Object
				AuditTrail auditTrail = new AuditTrail();
				auditTrail.setEntityId(entityId.toString());
				auditTrail.setEntityName(entityName);
				auditTrail.setNewPropValue(" ");
				auditTrail.setOldPropValue(" ");
				auditTrail.setOperationType(OPERATION_TYPE_DELETE);
				auditTrail.setActorName(userName);
				auditTrail.setPropertyName(OPERATION_TYPE_DELETE);
				auditTrail.setTransactionDate(transDate);
				Date a = new Date();
				auditTrail.setTransactionTime(a.getHours() + ":" + a.getMinutes());
				auditTrailQueryList.add(auditTrail);
				if (auditSaveenabled) {
					insertAuditRecords(auditTrailQueryList, session);
				}
				session.getTransaction().commit();
				session.close();
			}
		} catch (HibernateException e) {
			log.error("Unable to process audit log for DELETE operation", e);
		}
		return;
	}

	public void onPostInsert(PostInsertEvent event) {
		HashedMap dictionaryPropsHM = new HashedMap();
		Session session = event.getPersister().getFactory().openSession();

		if (!auditTrailenabled) {
			return;
		}
		try {
			EntityPersister persister = event.getPersister();
			final Serializable entityId = persister.hasIdentifierProperty() ? persister.getIdentifier(event.getEntity(), event.getPersister().guessEntityMode(event.getEntity())) : null;
			final String entityName = event.getEntity().getClass().getSimpleName();
			final EntityMode entityMode = persister.guessEntityMode(event.getEntity());

			if (!event.getEntity().getClass().getPackage().getName().startsWith("org.jbpm") && !entityName.equalsIgnoreCase("AuditTrail") && !entityName.equalsIgnoreCase("Dictionary")) {
				final String userName = getUserName();
				String[] propertyNames = persister.getPropertyNames();
				// Transaction tx = session.beginTransaction();
				List<AuditTrail> auditTrailQueryList = new ArrayList<AuditTrail>();
				for (int i = 0; i < propertyNames.length; i++) {
					String propertyName = propertyNames[i].toString();
					Object childObject = event.getPersister().getPropertyValue(event.getEntity(), propertyName, entityMode);
					if (!(childObject instanceof Collection)) {
						if (childObject == null)
							childObject = " ";

						AuditTrail auditTrail = new AuditTrail();
						auditTrail.setActorName(userName);
						auditTrail.setEntityId(entityId.toString());
						auditTrail.setEntityName(entityName);
						auditTrail.setPropertyName(propertyName);
						auditTrail.setTransactionDate(CommonUtils.getCurrentStringUIDate());
						auditTrail.setTransactionTime(new Date().getHours() + ":" + new Date().getMinutes());
						auditTrail.setOperationType(OPERATION_TYPE_INSERT);
						auditTrail.setNewPropValue(null);
						auditTrail.setOldPropValue(" ");

						if (childObject.getClass().getPackage().getName().startsWith("com.mars.")) {
							String updatedValue = null;
							ClassMetadata childMetadata = session.getSessionFactory().getClassMetadata(childObject.getClass());
							if (childMetadata != null) {
								updatedValue = childMetadata.getIdentifier(childObject, entityMode).toString();
								if (updatedValue != null && updatedValue.trim().length() > 0)
									auditTrail.setNewPropValue(updatedValue.toString());
							}
						} else {
							if (childObject != null && childObject instanceof java.util.Date) {
								auditTrail.setNewPropValue(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(childObject));
							} else if (childObject != null && childObject.toString().trim().length() > 0) {
								auditTrail.setNewPropValue(StringUtils.replaceChars(childObject.toString(), "\n", "<br/>"));
								// Store in HashMap so that the Dictionary
								// records can be saved later
								if(!propertyName.toLowerCase().contains("address") && !propertyName.toLowerCase().contains("remarks") && !propertyName.toLowerCase().contains("date"))
									dictionaryPropsHM.put(propertyNames[i].toString(), childObject.toString());
							}
						}

						if (auditTrail.getNewPropValue() != null && auditSaveenabled) {
							auditTrailQueryList.add(auditTrail);
							// session.save(auditTrail);
						}
					}
				}
				if (auditTrailQueryList != null && auditTrailQueryList.size() > 0)
					insertAuditRecords(auditTrailQueryList, session);
				// tx.commit();
			}
			saveDictionaryRecordsFromMap(dictionaryPropsHM, session);
			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
			log.error("Unable to process audit log for INSERT operation", e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return;
	}

	public void onPostUpdate(PostUpdateEvent event) {
		HashedMap dictionaryPropsHM = new HashedMap();
		Session session = event.getPersister().getFactory().openSession();

		if (!auditTrailenabled) {
			return;
		}
		try {
			EntityPersister persister = event.getPersister();
			SessionImplementor sessionImplementor = event.getSession();

			final Serializable entityId = persister.hasIdentifierProperty() ? persister.getIdentifier(event.getEntity(), event.getPersister().guessEntityMode(event.getEntity())) : null;
			final String entityName = event.getEntity().getClass().getSimpleName();
			final EntityMode entityMode = persister.guessEntityMode(event.getEntity());
			if (!event.getEntity().getClass().getPackage().getName().startsWith("org.jbpm") && !entityName.equalsIgnoreCase("AuditTrail") && !entityName.equalsIgnoreCase("Dictionary")) {
				final String userName = getUserName();
				// need to have a separate session for audit save

				Object[] databseObject = persister.getDatabaseSnapshot(event.getId(), sessionImplementor);
				if (databseObject != null) {

					Object[] currentObject = persister.getPropertyValues(event.getEntity(), entityMode);
					String[] propertyNames = persister.getPropertyNames();
					int[] indexes = persister.findModified(databseObject, currentObject, event.getEntity(), sessionImplementor);

					// if no changes made, return
					if (indexes == null) {
						return;
					}
					// Transaction transaction = session.beginTransaction();
					List<AuditTrail> auditTrailQueryList = new ArrayList<AuditTrail>();
					for (int i = 0; i < indexes.length; i++) {
						int chagnedIndex = indexes[i];

						if (currentObject[chagnedIndex] == null)
							currentObject[chagnedIndex] = " ";
						if (databseObject[chagnedIndex] == null)
							databseObject[chagnedIndex] = " ";

						Object childObject = currentObject[chagnedIndex];
						if (!(childObject instanceof Collection)) {
							AuditTrail auditTrail = new AuditTrail();
							auditTrail.setActorName(userName);
							auditTrail.setEntityId(entityId.toString());
							auditTrail.setEntityName(entityName);
							auditTrail.setPropertyName(propertyNames[chagnedIndex]);
							auditTrail.setTransactionDate(CommonUtils.getCurrentStringUIDate());
							auditTrail.setTransactionTime(new Date().getHours() + ":" + new Date().getMinutes());
							auditTrail.setOperationType(OPERATION_TYPE_UPDATE);
							if (childObject.getClass().getPackage().getName().startsWith("com.mars.")) {
								String updatedValue = null;
								try {
									ClassMetadata childMetadata = session.getSessionFactory().getClassMetadata(childObject.getClass());
									updatedValue = childMetadata.getIdentifier(childObject, entityMode).toString();
									auditTrail.setNewPropValue(updatedValue);
								} catch (Exception exception) {
								}
							} else {
								if (childObject != null && childObject instanceof java.util.Date) {
									auditTrail.setNewPropValue(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(childObject));
								} else {
									auditTrail.setNewPropValue(StringUtils.replaceChars(childObject.toString(), "\n", "<br/>"));
									// Store in HashMap so that the Dictionary
									// records can be saved later
									String strChangedProperty = propertyNames[chagnedIndex];
									if (strChangedProperty != null && strChangedProperty.endsWith("_" + dictionaryLanguageCode)) {
										String strEnglishProperty = strChangedProperty.replace("_" + dictionaryLanguageCode, "");
										String strEnglishPropertyValue = (String) persister.getPropertyValue(event.getEntity(), strEnglishProperty, entityMode);
										if (!dictionaryPropsHM.containsKey(strEnglishProperty)) {
											dictionaryPropsHM.put(strEnglishProperty, strEnglishPropertyValue);
										}
									}
									if(!strChangedProperty.toLowerCase().contains("address") && !strChangedProperty.toLowerCase().contains("remarks") && !strChangedProperty.toLowerCase().contains("date"))
										dictionaryPropsHM.put(propertyNames[chagnedIndex].toString(), childObject.toString());
								}
							}

							if (auditTrail.getNewPropValue() == null || auditTrail.getNewPropValue().trim().length() == 0) {
								auditTrail.setNewPropValue(" ");
							}
							auditTrail.setOldPropValue(StringUtils.replaceChars(databseObject[chagnedIndex].toString(), "\n", "<br/>"));
							if (auditSaveenabled && (auditTrail.getOldPropValue() != null && auditTrail.getNewPropValue() != null)
									&& !auditTrail.getOldPropValue().trim().equalsIgnoreCase(auditTrail.getNewPropValue().trim())) {
								auditTrailQueryList.add(auditTrail);
								// session.save(auditTrail);
							} else if (auditSaveenabled && auditTrail.getOldPropValue() == null && auditTrail.getNewPropValue() != null) {
								auditTrailQueryList.add(auditTrail);
								// session.save(auditTrail);
							} else if (auditSaveenabled && auditTrail.getOldPropValue() != null && auditTrail.getNewPropValue() == null) {
								auditTrailQueryList.add(auditTrail);
								// session.save(auditTrail);
							}
						}
					}
					if (auditTrailQueryList != null && auditTrailQueryList.size() > 0)
						insertAuditRecords(auditTrailQueryList, session);
				}
				// transaction.commit();
			}
			saveDictionaryRecordsFromMap(dictionaryPropsHM, session);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Unable to process audit log for UPDATE operation", e);
		}
		return;
	}

	/**
	 * Gets the current user's id from the Acegi secureContext
	 * 
	 * @return current user's userId
	 */
	private String getUserName() {
		SecurityContext secureContext = (SecurityContext) SecurityContextHolder.getContext();
		String userName = "anonymousUser";
		// secure context will be null when running unit tests so leave userId
		// as null
		try {
			if (secureContext != null) {
				Authentication auth = (Authentication) secureContext.getAuthentication();

				if (auth.getPrincipal() instanceof UserDetails) {
					UserDetails userDetails = (UserDetails) auth.getPrincipal();
					userName = userDetails.getUsername();
				} else {
					userName = auth.getPrincipal().toString();
				}

				if (userName == null || userName.equals("")) {
					return userName;
				} else {
					return userName;
				}

			} else {
				return userName;
			}

		} catch (Exception e) {
			// to handle , JBPM process deployments during webapp deployment.
			e.printStackTrace();
			log.error("Error Auit trail getUserName ", e);
		}
		return userName;
	}

	private void saveDictionaryRecordsFromMap(HashedMap dictionaryPropsHM, Session session) {
		// Looping through the HashMaP and storing the dictionaryRecords
		boolean saveDictionaryRecord = false;
		List<String> engValuesList = new ArrayList<String>();
		Map<String, Object> marathiValuesMap = new HashMap<String, Object>();
		String queryString = "";

		if (dictionaryEnabled) {
			Set set = dictionaryPropsHM.entrySet();
			Iterator i = set.iterator();
			while (i.hasNext()) {
				Map.Entry me = (Map.Entry) i.next();
				if (me.getKey().toString().endsWith("_" + dictionaryLanguageCode)) {
					String marathiKey = me.getKey().toString();
					String engKey = marathiKey.substring(0, marathiKey.indexOf("_" + dictionaryLanguageCode));
					String engVal = dictionaryPropsHM.get(engKey).toString();
					String marathiValue = me.getValue().toString();

					// Save to Dictionary only if its string and not number
					try {
						Long.parseLong(engVal);
					} catch (NumberFormatException e) {
						if (engValuesList.size() > 0) {
							queryString = queryString + ",'" + engVal.toUpperCase() + "'";
						} else {
							saveDictionaryRecord = true;
							queryString = "'" + engVal.toUpperCase() + "'";
						}
						engValuesList.add(engVal);
						marathiValuesMap.put(engVal, marathiValue);
					}
				}
			}
			if (saveDictionaryRecord) {
				saveDictionaryRecord(engValuesList, marathiValuesMap, queryString, session);
			}
		}
	}

	@SuppressWarnings("deprecation")
	private void saveDictionaryRecord(List<String> engValuesList, Map<String, Object> marathiValuesMap, String query, Session session) {

		String selectDictionQuery = "SELECT dictionary.dictionary_Id,dictionary.key,dictionary.value FROM Dictionary dictionary WHERE upper(dictionary.key) IN (" + query + ")";
		List<Dictionary> insertList = new ArrayList<Dictionary>();
		Map<String, Object> dbHashMap = new HashMap<String, Object>();

		try {
			Connection connection = session.connection();
			ResultSet resultSet = connection.createStatement().executeQuery(selectDictionQuery);
			while (resultSet.next()) {
				long dictionaryId = resultSet.getLong(1);
				String key = resultSet.getString(2);
				String dbvalue = resultSet.getString(3);
				String strMarathiValue = marathiValuesMap.get(key).toString();
				dbHashMap.put(key, dbvalue);
				if (StringUtils.isNotEmpty(strMarathiValue) && !strMarathiValue.equals(dbvalue)) {
					updateDictionaryRecord(dictionaryId, key, marathiValuesMap.get(key).toString(), session);
				}
			}

			for (String engval : engValuesList) {
				if (!dbHashMap.containsKey(engval) && StringUtils.isNotEmpty(marathiValuesMap.get(engval).toString())) {
					Dictionary dictionary = new Dictionary();
					dictionary.setKey(engval);
					dictionary.setValue(marathiValuesMap.get(engval).toString());
					insertList.add(dictionary);
				}
			}
			insertDictionaryRecord(insertList, session);
		} catch (SQLException e) {
			log.error("Error while saving dictionary records ");
			e.printStackTrace();
		}
	}

	private void updateDictionaryRecord(long dictionaryId, String key, String value, Session session) {

		StringBuffer updateQuery = new StringBuffer();

		updateQuery.append("UPDATE DICTIONARY SET  key = '");
		updateQuery.append(key);
		updateQuery.append("', value = '");
		updateQuery.append(value);
		updateQuery.append("' WHERE dictionary_id = ");
		updateQuery.append(dictionaryId);
		try {
			SQLQuery sqlQuery= session.createSQLQuery(updateQuery.toString());
			sqlQuery.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void insertDictionaryRecord(List<Dictionary> insertDictionaryList, Session session) {
		String sql = "INSERT INTO DICTIONARY(dictionary_id,key,value) VALUES (nextval('dictionary_seq'),?,?)";
		
		try{
			PreparedStatement preparedStatement = session.connection().prepareStatement(sql);
			for (Dictionary dictionary : insertDictionaryList) {
				preparedStatement.setString(1, dictionary.getKey());
				preparedStatement.setString(2, dictionary.getValue());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			preparedStatement.close();
		}catch(Exception e){
			log.error("Error while inserting audit records : Batch Update Failed ");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	private void insertAuditRecords(List<AuditTrail> auditTrailQueryList, Session session) {
		String sql = "INSERT INTO AUDIT_TRAIL (AUDIT_TRAIL_ID,ENTITY_ID,ENTITY_NAME,ENTITY_PROPERTY,ENTITY_PROPERTY_OLD_VALUE,ENTITY_PROPERTY_NEW_VALUE,OPERATION_TYPE,ACTOR_NAME,TRANSACTION_TIME,TRANSACTION_DATE) VALUES (nextval('audit_trail_seq'),?,?,?,?,?,?,?,?,?)";
		
		try{
			PreparedStatement preparedStatement = session.connection().prepareStatement(sql);
			for (AuditTrail auditTrail : auditTrailQueryList) {
				preparedStatement.setString(1, auditTrail.getEntityId());
				preparedStatement.setString(2, auditTrail.getEntityName());
				preparedStatement.setString(3, auditTrail.getPropertyName());
				preparedStatement.setString(4, auditTrail.getOldPropValue());
				preparedStatement.setString(5, auditTrail.getNewPropValue());
				preparedStatement.setString(6, auditTrail.getOperationType());
				preparedStatement.setString(7, auditTrail.getActorName());
				preparedStatement.setString(8, auditTrail.getTransactionTime());
				preparedStatement.setString(9, auditTrail.getTransactionDate());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			preparedStatement.close();
		}catch(Exception e){
			log.error("Error while inserting audit records : Batch Update Failed ");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
