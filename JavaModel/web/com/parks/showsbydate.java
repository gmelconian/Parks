package com.parks ;
import com.parks.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class showsbydate extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.parks.GXcfg.class);
      showsbydate pgm = new showsbydate (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      short aP0 = 0;
      java.util.Date aP1 = GXutil.nullDate();

      try
      {
         aP0 = (short) GXutil.lval( args[0]);
         aP1 = (java.util.Date) localUtil.ctod( args[1], 3);
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0, aP1);
   }

   public showsbydate( )
   {
      super( -1 , new ModelContext( showsbydate.class ), "" );
      Application.init(com.parks.GXcfg.class);
   }

   public showsbydate( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( showsbydate.class ), "" );
   }

   public showsbydate( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        java.util.Date aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             java.util.Date aP1 )
   {
      showsbydate.this.AV2SelectedParkID = aP0;
      showsbydate.this.AV3SelectedDateFrom = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      Application.cleanup(context, this, remoteHandle);
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV2SelectedParkID ;
   private short Gx_err ;
   private java.util.Date AV3SelectedDateFrom ;
}

