 JBoss AS 7.1.1 Final JSP Auto Deploy :
 
 1. Please make sure to add
            <configuration>
                <jsp-configuration development="true"/>
            </configuration>
    in standalone.xml under <subsystem xmlns="urn:jboss:domain:web:1.1" default-virtual-server="default-host" native="false">          

2. Go to jboss-as-7.1.1.Final/modules/org/jboss/as/web/main
   Place the jboss-as-web-7.1.1.Final-RECOMPILE.jar there. You can download from http://www.datafilehost.com/download-2cb9ff04.html

3. Open module.xml (jboss-as-7.1.1.Final/modules/org/jboss/as/web/main) and add the following line
        <!--resource-root path="jboss-as-web-7.1.1.Final.jar"/-->
        <resource-root path="jboss-as-web-7.1.1.Final-RECOMPILE.jar"/>

4.Open standalone.xml file available in "jboss7\standalone\configuration" folder.Paste below code after </extensions> tag and change value as per your requirement.
           <system-properties>
           <property name="org.apache.tomcat.util.http.Parameters.MAX_COUNT"            value="2000"/>
           </system-properties>

5.Adding following lines to jboss-as-7.1.1.Final\modules\sun\jdk\main\module.xml

	<dependencies>
		<system export="true">
			<paths>
				 ..


			   <path name="sun/net/www" />
			   <path name="com/sun/image/codec/jpeg"/>
			</paths>
			
	For DMS-Admin		
6.Add "SWFTools"(available in "\\172.16.25.51\nmmc\DMS") to "C:\Program Files".

7. Restart JBoss
