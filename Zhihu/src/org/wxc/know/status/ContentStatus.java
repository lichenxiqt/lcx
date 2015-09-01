package org.wxc.know.status;

/**
 * Activity状态之——不同的Body
 * @author Shawn Wang
 *
 */

public interface ContentStatus {
	int STATUS_HOME = 0;
	int STATUS_MINE = 1;
	int STATUS_FIND = 2;
	int STATUS_ATTENTION = 3;
	int STATUS_COLLECTION = 4;
	int STATUS_DRAFT = 5;
	int STATUS_ASK = 6;
	int STATUS_SETTING = 7;
	
	int STATUS_QUESTION = 8;
	int STATUS_ANSWER = 9;
	int STATUS_COMMENT = 10;
	int STATUS_PERSON = 11;
	int STATUS_TOPIC = 12;
	int STATUS_MSG = 13;
	int STATUS_SWITCH = 14;
}
