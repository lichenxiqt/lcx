package org.wxc.know.util;

import java.util.HashMap;
import java.util.Map;

import org.wxc.know.fragment.AskBody;
import org.wxc.know.fragment.AttentionBody;
import org.wxc.know.fragment.BaseFragment;
import org.wxc.know.fragment.CollectionBody;
import org.wxc.know.fragment.DraftBody;
import org.wxc.know.fragment.HomeBody;
import org.wxc.know.fragment.SettingBody;
import org.wxc.know.status.ContentStatus;

/**
 * 
 * @author Shawn Wang
 * 
 */
public class BodyManager {

	private static BodyManager instance = new BodyManager();

	public static Map<String, BaseFragment> bodys = new HashMap<String, BaseFragment>();;

	public static BodyManager getInstance() {
		return instance;
	}

	public BaseFragment getBody(int contentStatus) {
		BaseFragment bf = null;
		switch (contentStatus) {
		case ContentStatus.STATUS_HOME:
			bf = returnBody(HomeBody.class);
			break;
		case ContentStatus.STATUS_FIND:
			//bf = returnBody(FindBody.class);
			break;
		case ContentStatus.STATUS_ATTENTION:
			//bf = returnBody(AttentionBody.class);
			break;
		case ContentStatus.STATUS_COLLECTION:
			bf = returnBody(CollectionBody.class);
			break;
		case ContentStatus.STATUS_ASK:
			bf = returnBody(AskBody.class);
			break;
		case ContentStatus.STATUS_DRAFT:
			bf = returnBody(DraftBody.class);
			break;
		case ContentStatus.STATUS_SETTING:
			bf = returnBody(SettingBody.class);
			break;

		}

		return bf;
	}

	private BaseFragment returnBody(Class<? extends BaseFragment> clazz) {
		BaseFragment bf = null;

		String key = clazz.getSimpleName();
		try {
			if (bodys.containsKey(key)) {
				System.out.println("使用缓存Body");
				return bodys.get(key);
			} else {
				bf = clazz.newInstance();
				System.out.println(bf + "是空的吗？");
				bodys.put(key, bf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bf;
	}
}
