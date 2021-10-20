package com.parks ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ProgramNames", namespace ="Parks", propOrder={})
public final  class StructSdtProgramNames implements Cloneable, java.io.Serializable
{
   public StructSdtProgramNames( )
   {
   }

   public  StructSdtProgramNames( java.util.Vector<StructSdtProgramNames_ProgramName> value )
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

   @javax.xml.bind.annotation.XmlElement(name="ProgramName",namespace="Parks")
   public java.util.Vector<StructSdtProgramNames_ProgramName> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtProgramNames_ProgramName> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtProgramNames_ProgramName> item;
}

