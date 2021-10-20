package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.parks.ashowsbydate", "/com.parks.ashowsbydate"})
public final  class ashowsbydate extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new ashowsbydate_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new ashowsbydate_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Shows By Date";
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

