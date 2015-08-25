package test.win;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zkoss.zk.ui.Components;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.ext.AfterCompose;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Window;

public class Controller extends Window implements AfterCompose ,org.zkoss.zk.ui.util.Initiator{
	  protected DataBinder binder;
	    protected Session session;
	private String[] locations = { "applicationContext.xml" };
	public ApplicationContext ctx = new ClassPathXmlApplicationContext(
			locations);
	public void afterCompose() {
		// wire variables
		Components.wireVariables(this, this);

		// NO need to register onXxx event listeners

		// auto forward
		Components.addForwards(this, this);

	}
	public void doAfterCompose(Page arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	public boolean doCatch(Throwable arg0) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	public void doFinally() throws Exception {
		// TODO Auto-generated method stub
		
	}
	public void doInit(Page arg0, Object[] arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
