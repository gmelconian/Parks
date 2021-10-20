package com.parks ;
import com.parks.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class amusementparkslist extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.parks.GXcfg.class);
      amusementparkslist pgm = new amusementparkslist (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      short[] aP0 = new short[] {0};

      try
      {
         aP0[0] = (short) GXutil.lval( args[0]);
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0);
   }

   public amusementparkslist( )
   {
      super( -1 , new ModelContext( amusementparkslist.class ), "" );
      Application.init(com.parks.GXcfg.class);
   }

   public amusementparkslist( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( amusementparkslist.class ), "" );
   }

   public amusementparkslist( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( )
   {
      short[] aP0 = new short[] {0};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( short[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short[] aP0 )
   {
      amusementparkslist.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
   }

   protected void cleanup( )
   {
      this.aP0[0] = amusementparkslist.this.AV2CountryId;
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

   private short AV2CountryId ;
   private short Gx_err ;
   private short[] aP0 ;
}

