package com.parks ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColStringConcatenationUnitTestSDT", namespace ="Parks", propOrder={})
public final  class StructSdtColStringConcatenationUnitTestSDT implements Cloneable, java.io.Serializable
{
   public StructSdtColStringConcatenationUnitTestSDT( )
   {
   }

   public  StructSdtColStringConcatenationUnitTestSDT( java.util.Vector<StructSdtStringConcatenationUnitTestSDT> value )
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

   @javax.xml.bind.annotation.XmlElement(name="StringConcatenationUnitTestSDT",namespace="Parks")
   public java.util.Vector<StructSdtStringConcatenationUnitTestSDT> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtStringConcatenationUnitTestSDT> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtStringConcatenationUnitTestSDT> item;
}

