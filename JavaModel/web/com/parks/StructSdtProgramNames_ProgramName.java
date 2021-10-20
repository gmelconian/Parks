package com.parks ;
import com.genexus.*;

public final  class StructSdtProgramNames_ProgramName implements Cloneable, java.io.Serializable
{
   public StructSdtProgramNames_ProgramName( )
   {
      gxTv_SdtProgramNames_ProgramName_Name = "" ;
      gxTv_SdtProgramNames_ProgramName_Description = "" ;
      gxTv_SdtProgramNames_ProgramName_Link = "" ;
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

   public String getName( )
   {
      return gxTv_SdtProgramNames_ProgramName_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtProgramNames_ProgramName_N = (byte)(0) ;
      gxTv_SdtProgramNames_ProgramName_Name = value ;
   }

   public String getDescription( )
   {
      return gxTv_SdtProgramNames_ProgramName_Description ;
   }

   public void setDescription( String value )
   {
      gxTv_SdtProgramNames_ProgramName_N = (byte)(0) ;
      gxTv_SdtProgramNames_ProgramName_Description = value ;
   }

   public String getLink( )
   {
      return gxTv_SdtProgramNames_ProgramName_Link ;
   }

   public void setLink( String value )
   {
      gxTv_SdtProgramNames_ProgramName_N = (byte)(0) ;
      gxTv_SdtProgramNames_ProgramName_Link = value ;
   }

   protected byte gxTv_SdtProgramNames_ProgramName_N ;
   protected String gxTv_SdtProgramNames_ProgramName_Name ;
   protected String gxTv_SdtProgramNames_ProgramName_Description ;
   protected String gxTv_SdtProgramNames_ProgramName_Link ;
}

