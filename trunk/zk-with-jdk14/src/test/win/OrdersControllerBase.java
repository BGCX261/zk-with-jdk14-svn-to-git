package test.win;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import test.models.*;

import org.zkoss.lang.Strings;

import org.zkoss.spring.context.annotation.AfterCompose;
import org.zkoss.spring.context.annotation.EventHandler;
import org.zkoss.spring.jpa.EntityNotFoundException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.ClientInfoEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.KeyEvent;
import org.zkoss.zk.ui.event.SelectEvent;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zkplus.databind.BindingListModel;
import org.zkoss.zkplus.databind.DataBinder;


/* */
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.FieldComparator;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Timebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import org.zkoss.zul.Decimalbox;

import org.zkoss.zul.event.PageSizeEvent;
import org.zkoss.zul.event.PagingEvent;

public abstract class OrdersControllerBase  extends Controller{
	

	
	/****** Field Edit Components *******/
	
	protected Intbox ordernumber;
	
	protected Datebox orderdate;
	
	protected Datebox requireddate;
	
	protected Datebox shippeddate;
	
	protected Textbox status;
	
	protected Textbox comments;
	
	protected Intbox customernumber;

 
	
	
	/****** Zul Specific Application Control *******/
	//main control window
	
	protected Window ordersWin; //main window
	
	protected Listbox ordersDataListView; //domain object summary list
	
	protected Paging ordersPaging; //paging control for summary list
	
	protected Component ordersDetail; //domain object detail
	
	protected Component ordersEdit; //edit panel
	//buttons
	
	protected Button ordersCreate; //new button
	
	protected Button ordersUpdate; //edit button
	
	protected Button ordersDelete; //delete button
	
	protected Button ordersSave; //save button
	
	protected Button ordersCancel; //cancel button

	
	
	/****** Bean Field Edit Components *******/
	protected Orders _tmpSelected; //store original selected entity
	
	
	
	/****** Controller state Fields *******/
	//ZK databinder
	protected DataBinder binder;
	//Orders Model
	
	protected OrdersModelBase ordersModel = null;
	//operation transient state
	protected boolean _create; //when new a entity
	protected boolean _editMode; //switch to edit mode when doing editing(new/update)
	protected int _lastSelectedIndex = -1; //last selectedIndex before delete
	protected boolean _supportPaging = true; //switch to use Paging
	protected boolean _supportFilter = true; //TODO: switch to use Filter
	protected String _filter; //filters
	
	
	public OrdersControllerBase(){}
	
	 
	public void afterCompose() { 
		//initial to read one record so binder.loadAll() will not trigger unnecessary SQL 
		//The ordersWin.onClientInfo will load correct lines
		if (isSupportPaging()) {
			ordersModel.setMaxResults(1);
		}
		//The DataBinder that reads ZUML annotations to create binding info.
		binder = new AnnotateDataBinder(ordersWin);
		ordersWin.setVariable("ordersBinder", binder, true);
		binder.loadAll();
		
		final List model = (List) ordersDataListView.getModel(); 
		if (!model.isEmpty()) {
			ordersModel.setSelected((Orders)model.get(0));
			binder.loadComponent(ordersDetail);
		}
		setFocus();
	}
	
	public boolean isSupportPaging() {
		return _supportPaging;
	}
	
	public boolean isSupportFilter() {
		return _supportFilter;
	}
	
	public boolean isSupportExtra() {
		return isSupportFilter() || isSupportPaging();
	}
	
	public void setFilter(String filter) {
		_filter = filter;
	}
	
	public String getFilter() {
		return _filter;
	}
	
	
	protected Button ordersQuery;
	
 
	
 
	
	public OrdersModelBase getModel() {
		return ordersModel;
	}

	public void setModel(OrdersModelBase ordersModel) {
		this.ordersModel = ordersModel;
	}
	
	public void refreshModel() {
		binder.loadAttribute(ordersDataListView, "model"); //reload model to force refresh
	}

	//-- view/edit mode --//
	public void setEditMode(boolean b) {
		_editMode = b;
		switchMode();
	}
	
	public boolean isViewMode() {
		return !_editMode;
	}
	
	public boolean isEditMode() {
		return _editMode; 
	}

	public boolean isCreate() {
		return _create;
	}
	
	public boolean isNotSelected() {
		return this.ordersModel.getSelected() == null;
	}

	private void switchMode() {
		binder.loadComponent(ordersDetail); //reload visible to force refresh
		setFocus();
	}
	
	private void setFocus() {
		//post event so doSetFocus after the listbox is loaded ready
		Events.postEvent(new Event("onSetFocus", ordersWin));
	}
	 
public void doSetFocus$ordersWin() {
		if (_editMode) {
			ordernumber.focus();
		} else {
			if (((List)ordersDataListView.getModel()).isEmpty()) {
				//no result in list, focus on new button
				ordersCreate.focus();
			} else {
				if (_create) {
					ordersCreate.focus();
				} else {
					setListFocus();
}
			}
		}
	}
	
	private void setListFocus() {
		final Listitem li = ordersDataListView.getSelectedItem();
		if (li != null) {
			li.focus();
		} else {
			if (ordersModel.getSelected() != null) {
				ordersCreate.focus();
			} else {
				ordersCreate.focus();
			}
		}
	}
 
	public void doOK$ordersWin(Event event) {
		if (isEditMode()) {
			doSave$ordersSave(event);
		} else {
			doUpdate$ordersUpdate(event);
		}
	}
	
	 
	public void doClientInfo$ordersWin(Event event) {
		if (isSupportPaging()) {
			final ClientInfoEvent evt = (ClientInfoEvent) event;
			int height = evt.getDesktopHeight();
			int pageSize = Math.max((height - 130) / 14, 10); //estimated page size, at least 10
			int currentPageSize = ordersModel.getMaxResults(); 
			if (currentPageSize != pageSize) {
				ordersModel.setMaxResults(pageSize);
				final int inviewIndex = ordersDataListView.getSelectedIndex() < 0 ? 
					ordersModel.getOffset() : (ordersModel.getOffset() + ordersDataListView.getSelectedIndex()); 
				final int activePage = inviewIndex / pageSize; //new active page
				final int offset = activePage * pageSize;
				ordersModel.setOffset(offset);
				refreshModel();
				ordersPaging.setPageSize(pageSize);
				ordersPaging.setActivePage(activePage);
				setFocus();
			}
		}
	}
	
	 
	public void doPaging$ordersWin(Event event) {
		if (isSupportPaging()) {
			final int activePage = ordersPaging.getActivePage();
			final int offset = activePage * ordersPaging.getPageSize();
			ordersModel.setOffset(offset);
			refreshModel();
			setFocus();
		}
	}
	
	//-- ordersDataListView control --//
 
	public void doSelect$ordersWin(Event event) {
		final int index = ordersDataListView.getSelectedIndex();
		if (index >= 0) {
			_lastSelectedIndex = index;
			_create = false;
		}
	}
	
	//-- view mode control --//
 
	public void doCtrlKey$ordersWin(Event event) {
		final List items = ordersDataListView.getItems(); 
		if (!items.isEmpty() && (!_editMode || !_create)) {
			final int keycode = ((KeyEvent) event).getKeyCode();
			if (keycode == KeyEvent.DOWN || keycode == KeyEvent.UP){
				//handle no selected item case
				if (ordersDataListView.getSelectedIndex() < 0) { //no selected item
					//try our best to guess one
					if (_lastSelectedIndex >= 0) {
						final int index = Math.min(items.size() - 1, _lastSelectedIndex);
						ordersDataListView.setSelectedIndex(index);
						Events.sendEvent(new SelectEvent("onSelect", ordersDataListView, ordersDataListView.getSelectedItems()));
					}
				}
				setListFocus();
			}
		}
	}
	
 
	public void doCreate$ordersCreate(Event event) {
		if (isViewMode()) {
			//prepare a new Orders
			_tmpSelected = ordersModel.getSelected();
			_create = true;
			ordersModel.setSelected(new Orders());
			
			//switch to edit mode
			setEditMode(true);
		}
	}
	 
	public void doUpdate$ordersUpdate(Event event) {
		if (isViewMode()) {
			if (ordersModel.getSelected() != null) {
				_create = false;

				//switch to edit mode
				setEditMode(true);
			}
		}
	}
	 
	public void doDelete$ordersDelete(Event event) {
		if (isViewMode()) {
			if (ordersModel.getSelected() != null) {
				_create = false;
				newConfirmDelete().show();
			}
		}
	}

 
	public void doDeleteYes$ordersDelete(Event event) {
		if (isViewMode()) {
			beforeDelete();
			try {
				ordersModel.delete();
				ordersCreate.focus();		
			} catch (EntityNotFoundException e) { 
				//ignore, already deleted by others
			}
			ordersModel.setSelected(null);
			//refresh the todoList
			refreshModel();
			//update the ordersDetail
			switchMode();
		}
	}
	
	//-- sorting --//
	
	public void doSort(Event event) {
		final Listheader lh = (Listheader) event.getTarget();
		final String sortDirection = lh.getSortDirection(); //original direction
		if ("ascending".equals(sortDirection)) {
			final Comparator cmpr = lh.getSortDescending();
			if (cmpr instanceof FieldComparator) {
				final String orderBy = ((FieldComparator)cmpr).getOrderBy();
				ordersModel.setOrderBy(orderBy); //update query string
			}
		} else if ("descending".equals(sortDirection) || "natural".equals(sortDirection) || 
				Strings.isBlank(sortDirection)) {
			final Comparator cmpr = lh.getSortAscending();
			if (cmpr instanceof FieldComparator) {
				final String orderBy = ((FieldComparator)cmpr).getOrderBy();
				ordersModel.setOrderBy(orderBy); //update query string
			}
		}
		
		if (isSupportPaging()) {
			refreshModel();
		}
		setFocus();
	}
	
	//-- edit mode control --//
	 
	public void doSave$ordersSave(Event event) {
		if (isEditMode()) {
			//validate
			validate();

			//save into orders
			binder.saveComponent(ordersEdit); //reload model to force refresh
			
			//store into db
			if (_create) {
				beforeCreate();
				this.ordersModel.persist();
			} else {
				beforeUpdate();
				try {
					this.ordersModel.merge();
				} catch (EntityNotFoundException e1) {
					try {
						Messagebox.show(getUpdateDeletedMessage());
					} catch (InterruptedException e2) {
						//ignore
					}
				}
			}
			//refresh the todoList
			refreshModel();
			//switch to view mode
			setEditMode(false);
		}
	}

	 
	public void doCancel$ordersCancel(Event event) {
		if (isEditMode()) {
			//restore to original selected Orders if cancel from new
			if (_create) {
				ordersModel.setSelected(_tmpSelected);
				_tmpSelected = null;
			}
			
			//switch to view mode
			setEditMode(false);
		}
	}
	
	//--To be override--// 
	/** Validate the input field */
	protected void validate() {
ordernumber.getValue();
orderdate.getValue();
requireddate.getValue();
status.getValue();
customernumber.getValue();

	}
	
	/** The info message when end user trying to update a "deleted" entity. */
	protected String getUpdateDeletedMessage() {
		return "Cannot find the selected item, might have been deleted by others.";
	}
	
	/** Get a instance of ConfirmDelete class */
	protected ConfirmDelete newConfirmDelete() {
		return new ConfirmDelete();
	}
	
	/** Delete Confirmation */
	protected class ConfirmDelete {
		/** Show the ConfirmDelete Messagebox */
		public void show() {
			try {
				Messagebox.show(getConfirmMessage(),
				        getConfirmTitle(),
				        Messagebox.YES+Messagebox.NO,
				        Messagebox.EXCLAMATION,
				        new org.zkoss.zk.ui.event.EventListener() {
							public void onEvent(Event event) {
								if ("onYes".equals(event.getName())) {
									doYes();
								}
							}
						}
					);
			} catch (InterruptedException ex) {
				//ignore
			}
		}
		
		/** Operation when end user click Yes button in confirm delete Messagebox*/
		public void doYes() {
			//have to send Event to change the current IdSpace to "ordersWin" 
			Events.sendEvent(new Event("onDeleteYes", ordersDelete));
		}
	}
	
	protected String getConfirmMessage(){
		return "Are you sure?";
	}
	
	protected String getConfirmTitle(){
		return "Are you sure you want to delete the selected item?";
	}
	
	protected void beforeCreate(){
	}
	
	protected void beforeUpdate(){
	}
	
	protected void beforeDelete(){
	}
}
