package test.win;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zkoss.zul.*;
 
import test.models.*;
import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.Event;
import java.util.*;
import org.zkoss.zkplus.databind.DataBinder;

import org.zkoss.zk.ui.ext.*;

public class CRUD extends Controller {

	   protected Listbox ordersList; 
	  OrdersDAO boss = (OrdersDAO) ctx.getBean("OrdersDAO");
		List ab = null;
		 public Window orderswin;
      protected List abc=boss.findAll();
	public void doInit(Page page, Object[] args) throws Exception {
			try {
			 
				  binder = (DataBinder) getVariable("binder", true);

			   //     final List model = (List) ordersList.getModel();	
				
			ab = boss.findAll();
			 ListModel  ordersmodel=new SimpleListModel(ab);
	// 把 变量放到页面里去了	
			 page.setVariable((String) args[0], ab);
		 
			// Use setVariable to pass the result back to the page
		} catch (Exception ex) {
			throw UiException.Aide.wrap(ex);
		}
	}

}
