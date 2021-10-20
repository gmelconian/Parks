package com.parks ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColTransactionContext.Attribute", namespace ="Parks", propOrder={})
public final  class StructSdtColTransactionContext_Attribute implements Cloneable, java.io.Serializable
{
   public StructSdtColTransactionContext_Attribute( )
   {
   }

   public  StructSdtColTransactionContext_Attribute( java.util.Vector<StructSdtTransactionContext_Attribute> value )
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

   @javax.xml.bind.annotation.XmlElement(name="TransactionContext.Attribute",namespace="Parks")
   public java.util.Vector<StructSdtTransactionContext_Attribute> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtTransactionContext_Attribute> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtTransactionContext_Attribute> item;
}

