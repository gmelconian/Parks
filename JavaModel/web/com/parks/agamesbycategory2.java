package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.parks.agamesbycategory2", "/com.parks.agamesbycategory2"})
public final  class agamesbycategory2 extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new agamesbycategory2_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new agamesbycategory2_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Games By Category2";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

}

