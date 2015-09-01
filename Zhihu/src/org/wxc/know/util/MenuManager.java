package org.wxc.know.util;

import java.util.Observable;

/**
 * 定义一个Menu是否显示的被观察者
 * @author Shawn Wang
 *
 */
public class MenuManager extends Observable {
	public static boolean isMenuShow;
	
	public void setIsMenuShow(boolean isMenuShow){
		this.isMenuShow = isMenuShow;
		notifyObservers();
	}
}
