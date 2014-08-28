package com.pinternals.mailclientadapter;
import javax.resource.ResourceException;

import com.sap.aii.af.lib.ra.cci.XIMessageRecord;
import com.sap.engine.interfaces.messaging.api.Action;
import com.sap.engine.interfaces.messaging.api.Message;
import com.sap.engine.interfaces.messaging.api.MessageFactory;
import com.sap.engine.interfaces.messaging.api.Party;
import com.sap.engine.interfaces.messaging.api.PublicAPIAccess;
import com.sap.engine.interfaces.messaging.api.PublicAPIAccessFactory;
import com.sap.engine.interfaces.messaging.api.Service;
 
 public class XIMessageRecordImpl
   implements XIMessageRecord
 {
   private static final String AF_MSGFCT_TYPE = "XI";
   static final long serialVersionUID = 6501765867377473542L;
   private static final XITrace TRACE = new XITrace(XIMessageRecordImpl.class.getName());
   private Message msg = null;
   private final String recordName = "XiAfCciMessageRecord";
   private String recordShortDescription = "XI AF CCI record for messages";
   private PublicAPIAccess pubAPI = null;
   private MessageFactory mf = null;
   
   private void accessMessageFactory()
     throws ResourceException
   {
     String SIGNATURE = "accessMessageFactory()";
     TRACE.entering("accessMessageFactory()");
     try
     {
       this.pubAPI = PublicAPIAccessFactory.getPublicAPIAccess();
       this.mf = this.pubAPI.createMessageFactory("XI");
     }
     catch (Exception e)
     {
       TRACE.catching("accessMessageFactory()", e);
       ResourceException re = new ResourceException(e.getMessage());
       TRACE.throwing("accessMessageFactory()", re);
       throw re;
     }
     TRACE.exiting("accessMessageFactory()");
   }
   
   public XIMessageRecordImpl(Party fromParty, Party toParty, Service fromService, Service toService, Action action)
     throws ResourceException
   {
     String SIGNATURE = "CciMessage(Party fromParty, Party toParty, Service fromService, Service toService, Action action)";
     TRACE.entering("CciMessage(Party fromParty, Party toParty, Service fromService, Service toService, Action action)", new Object[] { fromParty, toParty, fromService, toService, action });
     try
     {
       accessMessageFactory();
       this.msg = this.mf.createMessage(fromParty, toParty, fromService, toService, action);
     }
     catch (Exception e)
     {
       TRACE.catching("CciMessage(Party fromParty, Party toParty, Service fromService, Service toService, Action action)", e);
       ResourceException re = new ResourceException(e.getMessage());
       TRACE.throwing("CciMessage(Party fromParty, Party toParty, Service fromService, Service toService, Action action)", re);
       throw re;
     }
     TRACE.exiting("CciMessage(Party fromParty, Party toParty, Service fromService, Service toService, Action action)");
   }
   
   public XIMessageRecordImpl(Party fromParty, Party toParty, Service fromService, Service toService, Action action, String messageId)
     throws ResourceException
   {
     String SIGNATURE = "CciMessage(Party fromParty, Party toParty, Service fromService, Service toService, Action action, String messageId)";
     TRACE.entering("CciMessage(Party fromParty, Party toParty, Service fromService, Service toService, Action action, String messageId)", new Object[] { fromParty, toParty, fromService, toService, action, messageId });
     try
     {
       accessMessageFactory();
       this.msg = this.mf.createMessage(fromParty, toParty, fromService, toService, action, messageId);
     }
     catch (Exception e)
     {
       TRACE.catching("CciMessage(Party fromParty, Party toParty, Service fromService, Service toService, Action action, String messageId)", e);
       ResourceException re = new ResourceException(e.getMessage());
       TRACE.throwing("CciMessage(Party fromParty, Party toParty, Service fromService, Service toService, Action action, String messageId)", re);
       throw re;
     }
     TRACE.exiting("CciMessage(Party fromParty, Party toParty, Service fromService, Service toService, Action action, String messageId)");
   }
   
   public XIMessageRecordImpl(Message msg)
   {
     this.msg = msg;
   }
   
   public String getRecordName()
   {
     return "XiAfCciMessageRecord";
   }
   
   public void setRecordName(String name) {}
   
   public void setRecordShortDescription(String recordShortDescription)
   {
     this.recordShortDescription = recordShortDescription;
   }
   
   public String getRecordShortDescription()
   {
     return this.recordShortDescription;
   }
   
   public Object clone()
     throws CloneNotSupportedException
   {
     String SIGNATURE = "clone()";
     TRACE.entering("clone()");
     XIMessageRecordImpl cloned = null;
     try
     {
       cloned = new XIMessageRecordImpl(this.msg.getFromParty(), this.msg.getToParty(), this.msg.getFromService(), this.msg.getToService(), this.msg.getAction(), this.msg.getMessageId());
       Message clonedMsg = cloned.getXIMessage();
       clonedMsg.setSequenceId(this.msg.getSequenceId());
       clonedMsg.setDeliverySemantics(this.msg.getDeliverySemantics());
       clonedMsg.setDocument(this.msg.getDocument());
       clonedMsg.setRefToMessageId(this.msg.getRefToMessageId());
       cloned.setRecordName(getRecordName());
       cloned.setRecordShortDescription(getRecordShortDescription());
     }
     catch (Exception e)
     {
       TRACE.catching("clone()", e);
       CloneNotSupportedException ce = new CloneNotSupportedException(e.getMessage());
       TRACE.throwing("clone()", ce);
       throw ce;
     }
     TRACE.exiting("clone()");
     return cloned;
   }
   
   public void setXIMessage(Message message)
   {
     this.msg = message;
   }
   
   public Message getXIMessage()
   {
     return this.msg;
   }
 }

