package com.greedy.section01.contextlistener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ContextListenerTest implements ServletContextListener, ServletContextAttributeListener {

    /* context가 생성 될 때 변화를 감지하는 Listener 인스턴스가 함께 생성 된다. */
    public ContextListenerTest() {
    	System.out.println("context listener 인스턴스 생성");
    }

    /* context에 attribute가 추가 될 때 동작한다. */
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	System.out.println("context attribute added!!");
    }

    /* context에 attribute가 제거 될 때 동작한다. */
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	System.out.println("context attribute removed!!");
    }
    
    /* context가 소멸할 때 동작한다. */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("context destoryed!!");
    }

    /* context에 attribute가 교체 될 때 동작한다. */
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	System.out.println("context attribute replaced!!");
    }

    /* context가 초기화 될 때 동작한다. */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("context initialized!!");
    }
	
}
