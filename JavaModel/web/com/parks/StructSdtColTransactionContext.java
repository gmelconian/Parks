package com.parks ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColTransactionContext", namespace ="Parks", propOrder={})
public final  class StructSdtColTransactionContext implements Cloneable, java.io.Serializable
{
   public StructSdtColTransactionContext( )
   {
   }

   public  StructSdtColTransactionContext( java.util.Vector<StructSdtTransactionContext> value )
   {
      item = value;
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

   @javax.xml.bind.annotation.XmlElement(name="TransactionContext",namespace="Parks")
   public java.util.Vector<StructSdtTransactionContext> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtTransactionContext> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtTransactionContext> item;
}

