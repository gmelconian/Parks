package com.parks ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "TabOptions", namespace ="Parks", propOrder={})
public final  class StructSdtTabOptions implements Cloneable, java.io.Serializable
{
   public StructSdtTabOptions( )
   {
   }

   public  StructSdtTabOptions( java.util.Vector<StructSdtTabOptions_TabOptionsItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="TabOptionsItem",namespace="Parks")
   public java.util.Vector<StructSdtTabOptions_TabOptionsItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtTabOptions_TabOptionsItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtTabOptions_TabOptionsItem> item;
}

