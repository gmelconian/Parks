package com.parks ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "LinkList", namespace ="GeneXus", propOrder={})
public final  class StructSdtLinkList implements Cloneable, java.io.Serializable
{
   public StructSdtLinkList( )
   {
   }

   public  StructSdtLinkList( java.util.Vector<StructSdtLinkList_LinkItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="LinkItem",namespace="GeneXus")
   public java.util.Vector<StructSdtLinkList_LinkItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtLinkList_LinkItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtLinkList_LinkItem> item;
}

