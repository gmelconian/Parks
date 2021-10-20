package com.parks ;
import com.genexus.*;

public final  class StructSdtTransactionContext implements Cloneable, java.io.Serializable
{
   public StructSdtTransactionContext( )
   {
      gxTv_SdtTransactionContext_Callerobject = "" ;
      gxTv_SdtTransactionContext_Callerurl = "" ;
      gxTv_SdtTransactionContext_Transactionname = "" ;
      gxTv_SdtTransactionContext_Attributes_N = (byte)(1) ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getCallerobject( )
   {
      return gxTv_SdtTransactionContext_Callerobject ;
   }

   public void setCallerobject( String value )
   {
      gxTv_SdtTransactionContext_N = (byte)(0) ;
      gxTv_SdtTransactionContext_Callerobject = value ;
   }

   public boolean getCallerondelete( )
   {
      return gxTv_SdtTransactionContext_Callerondelete ;
   }

   public void setCallerondelete( boolean value )
   {
      gxTv_SdtTransactionContext_N = (byte)(0) ;
      gxTv_SdtTransactionContext_Callerondelete = value ;
   }

   public String getCallerurl( )
   {
      return gxTv_SdtTransactionContext_Callerurl ;
   }

   public void setCallerurl( String value )
   {
      gxTv_SdtTransactionContext_N = (byte)(0) ;
      gxTv_SdtTransactionContext_Callerurl = value ;
   }

   public String getTransactionname( )
   {
      return gxTv_SdtTransactionContext_Transactionname ;
   }

   public void setTransactionname( String value )
   {
      gxTv_SdtTransactionContext_N = (byte)(0) ;
      gxTv_SdtTransactionContext_Transactionname = value ;
   }

   public java.util.Vector<com.parks.StructSdtTransactionContext_Attribute> getAttributes( )
   {
      return gxTv_SdtTransactionContext_Attributes ;
   }

   public void setAttributes( java.util.Vector<com.parks.StructSdtTransactionContext_Attribute> value )
   {
      gxTv_SdtTransactionContext_Attributes_N = (byte)(0) ;
      gxTv_SdtTransactionContext_N = (byte)(0) ;
      gxTv_SdtTransactionContext_Attributes = value ;
   }

   protected byte gxTv_SdtTransactionContext_Attributes_N ;
   protected byte gxTv_SdtTransactionContext_N ;
   protected boolean gxTv_SdtTransactionContext_Callerondelete ;
   protected String gxTv_SdtTransactionContext_Callerobject ;
   protected String gxTv_SdtTransactionContext_Callerurl ;
   protected String gxTv_SdtTransactionContext_Transactionname ;
   protected java.util.Vector<com.parks.StructSdtTransactionContext_Attribute> gxTv_SdtTransactionContext_Attributes=null ;
}

