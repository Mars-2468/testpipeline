package com.mars.workflow.utils;

import java.util.Comparator;
import java.util.Date;

import org.jbpm.api.task.Task;

public class PersoalTaskCompartor implements Comparator<Task> {

	String strSort = "priority";

	public PersoalTaskCompartor(String sortBy) {
		if (sortBy != null)
			strSort = sortBy;
	}

	public int compare(Task task1, Task task2) {
		int index = 0;
		if (strSort.equalsIgnoreCase("priority"))
			index = compareByPriority(task1, task2);
		else if (strSort.equalsIgnoreCase("startDate"))
			index = compareByDate(task1, task2);
		return index;
	}

	private int compareByPriority(Task task1, Task task2) {
		int priority1 = ((Task) task1).getPriority();

		int priority2 = ((Task) task2).getPriority();

		if (priority1 < priority2)
			return 1;
		else if (priority1 > priority2)
			return -1;
		else
			return 0;
	}

	private int compareByDate(Task task1, Task task2) {
		Date priority1 = ((Task) task1).getCreateTime();

		Date priority2 = ((Task) task2).getCreateTime();

		if (priority1.getTime() < priority2.getTime())
			return 1;
		else if (priority1.getTime() > priority2.getTime())
			return -1;
		else
			return 0;
	}
}
