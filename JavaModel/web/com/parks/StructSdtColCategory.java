package com.parks ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColCategory", namespace ="Parks", propOrder={})
public final  class StructSdtColCategory implements Cloneable, java.io.Serializable
{
   public StructSdtColCategory( )
   {
   }

   public  StructSdtColCategory( java.util.Vector<StructSdtCategory> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Category",namespace="Parks")
   public java.util.Vector<StructSdtCategory> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtCategory> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtCategory> item;
}

