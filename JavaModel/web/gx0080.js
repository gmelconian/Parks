gx.evt.autoSkip=!1;gx.define("gx0080",!1,function(){var n,t;this.ServerClass="gx0080";this.PackageName="com.parks";this.ServerFullClass="com.parks.gx0080";this.setObjectType("web");this.anyGridBaseTable=!0;this.hasEnterEvent=!0;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.SetStandaloneVars=function(){this.AV13pRepairId=gx.fn.getIntegerValue("vPREPAIRID",".")};this.Validv_Crepairbegindate=function(){return this.validCliEvt("Validv_Crepairbegindate",0,function(){try{var n=gx.util.balloon.getNew("vCREPAIRBEGINDATE");if(this.AnyError=0,!(new gx.date.gxdate("").compare(this.AV7cRepairBeginDate)===0||new gx.date.gxdate(this.AV7cRepairBeginDate).compare(gx.date.ymdtod(1e3,1,1))>=0))try{n.setError("Campo Repair Begin Date fuera de rango");this.AnyError=gx.num.trunc(1,0)}catch(t){}}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e18151_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("ADVANCEDCONTAINER","Class"),"AdvancedContainer")==0?(gx.fn.setCtrlProperty("ADVANCEDCONTAINER","Class","AdvancedContainer AdvancedContainerVisible"),gx.fn.setCtrlProperty("BTNTOGGLE","Class",gx.fn.getCtrlProperty("BTNTOGGLE","Class")+" BtnToggleActive")):(gx.fn.setCtrlProperty("ADVANCEDCONTAINER","Class","AdvancedContainer"),gx.fn.setCtrlProperty("BTNTOGGLE","Class","BtnToggle")),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("ADVANCEDCONTAINER","Class")',ctrl:"ADVANCEDCONTAINER",prop:"Class"},{ctrl:"BTNTOGGLE",prop:"Class"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e11151_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("REPAIRIDFILTERCONTAINER","Class"),"AdvancedContainerItem")==0?(gx.fn.setCtrlProperty("REPAIRIDFILTERCONTAINER","Class","AdvancedContainerItem AdvancedContainerItemExpanded"),gx.fn.setCtrlProperty("vCREPAIRID","Visible",!0)):(gx.fn.setCtrlProperty("REPAIRIDFILTERCONTAINER","Class","AdvancedContainerItem"),gx.fn.setCtrlProperty("vCREPAIRID","Visible",!1)),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("REPAIRIDFILTERCONTAINER","Class")',ctrl:"REPAIRIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCREPAIRID","Visible")',ctrl:"vCREPAIRID",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12151_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("REPAIRBEGINDATEFILTERCONTAINER","Class"),"AdvancedContainerItem")==0?gx.fn.setCtrlProperty("REPAIRBEGINDATEFILTERCONTAINER","Class","AdvancedContainerItem AdvancedContainerItemExpanded"):gx.fn.setCtrlProperty("REPAIRBEGINDATEFILTERCONTAINER","Class","AdvancedContainerItem"),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("REPAIRBEGINDATEFILTERCONTAINER","Class")',ctrl:"REPAIRBEGINDATEFILTERCONTAINER",prop:"Class"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e13151_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("REPAIRDAYSFILTERCONTAINER","Class"),"AdvancedContainerItem")==0?(gx.fn.setCtrlProperty("REPAIRDAYSFILTERCONTAINER","Class","AdvancedContainerItem AdvancedContainerItemExpanded"),gx.fn.setCtrlProperty("vCREPAIRDAYS","Visible",!0)):(gx.fn.setCtrlProperty("REPAIRDAYSFILTERCONTAINER","Class","AdvancedContainerItem"),gx.fn.setCtrlProperty("vCREPAIRDAYS","Visible",!1)),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("REPAIRDAYSFILTERCONTAINER","Class")',ctrl:"REPAIRDAYSFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCREPAIRDAYS","Visible")',ctrl:"vCREPAIRDAYS",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e14151_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("GAMEIDFILTERCONTAINER","Class"),"AdvancedContainerItem")==0?(gx.fn.setCtrlProperty("GAMEIDFILTERCONTAINER","Class","AdvancedContainerItem AdvancedContainerItemExpanded"),gx.fn.setCtrlProperty("vCGAMEID","Visible",!0)):(gx.fn.setCtrlProperty("GAMEIDFILTERCONTAINER","Class","AdvancedContainerItem"),gx.fn.setCtrlProperty("vCGAMEID","Visible",!1)),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("GAMEIDFILTERCONTAINER","Class")',ctrl:"GAMEIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCGAMEID","Visible")',ctrl:"vCGAMEID",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e15151_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("TECHNICIANIDFILTERCONTAINER","Class"),"AdvancedContainerItem")==0?(gx.fn.setCtrlProperty("TECHNICIANIDFILTERCONTAINER","Class","AdvancedContainerItem AdvancedContainerItemExpanded"),gx.fn.setCtrlProperty("vCTECHNICIANID","Visible",!0)):(gx.fn.setCtrlProperty("TECHNICIANIDFILTERCONTAINER","Class","AdvancedContainerItem"),gx.fn.setCtrlProperty("vCTECHNICIANID","Visible",!1)),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("TECHNICIANIDFILTERCONTAINER","Class")',ctrl:"TECHNICIANIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCTECHNICIANID","Visible")',ctrl:"vCTECHNICIANID",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16151_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("REPAIRCOSTFILTERCONTAINER","Class"),"AdvancedContainerItem")==0?(gx.fn.setCtrlProperty("REPAIRCOSTFILTERCONTAINER","Class","AdvancedContainerItem AdvancedContainerItemExpanded"),gx.fn.setCtrlProperty("vCREPAIRCOST","Visible",!0)):(gx.fn.setCtrlProperty("REPAIRCOSTFILTERCONTAINER","Class","AdvancedContainerItem"),gx.fn.setCtrlProperty("vCREPAIRCOST","Visible",!1)),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("REPAIRCOSTFILTERCONTAINER","Class")',ctrl:"REPAIRCOSTFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCREPAIRCOST","Visible")',ctrl:"vCREPAIRCOST",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e17151_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("TECHNICIANALTERNATEIDFILTERCONTAINER","Class"),"AdvancedContainerItem")==0?(gx.fn.setCtrlProperty("TECHNICIANALTERNATEIDFILTERCONTAINER","Class","AdvancedContainerItem AdvancedContainerItemExpanded"),gx.fn.setCtrlProperty("vCTECHNICIANALTERNATEID","Visible",!0)):(gx.fn.setCtrlProperty("TECHNICIANALTERNATEIDFILTERCONTAINER","Class","AdvancedContainerItem"),gx.fn.setCtrlProperty("vCTECHNICIANALTERNATEID","Visible",!1)),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("TECHNICIANALTERNATEIDFILTERCONTAINER","Class")',ctrl:"TECHNICIANALTERNATEIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCTECHNICIANALTERNATEID","Visible")',ctrl:"vCTECHNICIANALTERNATEID",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e21152_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e22151_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,85,86,87,88,89,90,91,92,93,94,95];this.GXLastCtrlId=95;this.Grid1Container=new gx.grid.grid(this,2,"WbpLvl2",84,"Grid1","Grid1","Grid1Container",this.CmpContext,this.IsMasterPage,"gx0080",[],!1,1,!1,!0,10,!0,!1,!1,"",0,"px",0,"px","Nueva fila",!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);t=this.Grid1Container;t.addBitmap("&Linkselection","vLINKSELECTION",85,0,"px",17,"px",null,"","","SelectionAttribute","WWActionColumn");t.addSingleLineEdit(27,86,"REPAIRID","Id","","RepairId","int",0,"px",4,4,"right",null,[],27,"RepairId",!0,0,!1,!1,"Attribute",1,"WWColumn");t.addSingleLineEdit(28,87,"REPAIRBEGINDATE","Begin Date","","RepairBeginDate","date",0,"px",8,8,"right",null,[],28,"RepairBeginDate",!0,0,!1,!1,"DescriptionAttribute",1,"WWColumn");t.addSingleLineEdit(29,88,"REPAIRDAYS","Days","","RepairDays","int",0,"px",4,4,"right",null,[],29,"RepairDays",!0,0,!1,!1,"Attribute",1,"WWColumn OptionalColumn");t.addSingleLineEdit(17,89,"GAMEID","Game Id","","GameId","int",0,"px",4,4,"right",null,[],17,"GameId",!0,0,!1,!1,"Attribute",1,"WWColumn OptionalColumn");t.addSingleLineEdit(30,90,"TECHNICIANID","Technician Id","","TechnicianId","int",0,"px",4,4,"right",null,[],30,"TechnicianId",!0,0,!1,!1,"Attribute",1,"WWColumn OptionalColumn");t.addSingleLineEdit(34,91,"REPAIRCOST","Cost","","RepairCost","decimal",0,"px",8,8,"right",null,[],34,"RepairCost",!0,2,!1,!1,"Attribute",1,"WWColumn OptionalColumn");t.addSingleLineEdit(35,92,"TECHNICIANALTERNATEID","Alternate Id","","TechnicianAlternateId","int",0,"px",4,4,"right",null,[],35,"TechnicianAlternateId",!0,0,!1,!1,"Attribute",1,"WWColumn OptionalColumn");this.Grid1Container.emptyText="";this.setGrid(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"MAIN",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"ADVANCEDCONTAINER",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"REPAIRIDFILTERCONTAINER",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"LBLREPAIRIDFILTER",format:1,grid:0,evt:"e11151_client",ctrltype:"textblock"};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"",grid:0};n[16]={id:16,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vCREPAIRID",gxz:"ZV6cRepairId",gxold:"OV6cRepairId",gxvar:"AV6cRepairId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV6cRepairId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV6cRepairId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCREPAIRID",gx.O.AV6cRepairId,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV6cRepairId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCREPAIRID",".")},nac:gx.falseFn};n[17]={id:17,fld:"",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"REPAIRBEGINDATEFILTERCONTAINER",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"LBLREPAIRBEGINDATEFILTER",format:1,grid:0,evt:"e12151_client",ctrltype:"textblock"};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[26]={id:26,lvl:0,type:"date",len:8,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Validv_Crepairbegindate,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vCREPAIRBEGINDATE",gxz:"ZV7cRepairBeginDate",gxold:"OV7cRepairBeginDate",gxvar:"AV7cRepairBeginDate",dp:{f:-1,st:!1,wn:!1,mf:!1,pic:"99/99/99",dec:0},ucs:[],op:[26],ip:[26],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV7cRepairBeginDate=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.ZV7cRepairBeginDate=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("vCREPAIRBEGINDATE",gx.O.AV7cRepairBeginDate,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV7cRepairBeginDate=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getControlValue("vCREPAIRBEGINDATE")},nac:gx.falseFn};n[27]={id:27,fld:"",grid:0};n[28]={id:28,fld:"",grid:0};n[29]={id:29,fld:"REPAIRDAYSFILTERCONTAINER",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"LBLREPAIRDAYSFILTER",format:1,grid:0,evt:"e13151_client",ctrltype:"textblock"};n[33]={id:33,fld:"",grid:0};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"",grid:0};n[36]={id:36,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vCREPAIRDAYS",gxz:"ZV8cRepairDays",gxold:"OV8cRepairDays",gxvar:"AV8cRepairDays",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV8cRepairDays=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV8cRepairDays=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCREPAIRDAYS",gx.O.AV8cRepairDays,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV8cRepairDays=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCREPAIRDAYS",".")},nac:gx.falseFn};n[37]={id:37,fld:"",grid:0};n[38]={id:38,fld:"",grid:0};n[39]={id:39,fld:"GAMEIDFILTERCONTAINER",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"LBLGAMEIDFILTER",format:1,grid:0,evt:"e14151_client",ctrltype:"textblock"};n[43]={id:43,fld:"",grid:0};n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"",grid:0};n[46]={id:46,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vCGAMEID",gxz:"ZV9cGameId",gxold:"OV9cGameId",gxvar:"AV9cGameId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV9cGameId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV9cGameId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCGAMEID",gx.O.AV9cGameId,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV9cGameId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCGAMEID",".")},nac:gx.falseFn};n[47]={id:47,fld:"",grid:0};n[48]={id:48,fld:"",grid:0};n[49]={id:49,fld:"TECHNICIANIDFILTERCONTAINER",grid:0};n[50]={id:50,fld:"",grid:0};n[51]={id:51,fld:"",grid:0};n[52]={id:52,fld:"LBLTECHNICIANIDFILTER",format:1,grid:0,evt:"e15151_client",ctrltype:"textblock"};n[53]={id:53,fld:"",grid:0};n[54]={id:54,fld:"",grid:0};n[55]={id:55,fld:"",grid:0};n[56]={id:56,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vCTECHNICIANID",gxz:"ZV10cTechnicianId",gxold:"OV10cTechnicianId",gxvar:"AV10cTechnicianId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV10cTechnicianId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV10cTechnicianId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCTECHNICIANID",gx.O.AV10cTechnicianId,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV10cTechnicianId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCTECHNICIANID",".")},nac:gx.falseFn};n[57]={id:57,fld:"",grid:0};n[58]={id:58,fld:"",grid:0};n[59]={id:59,fld:"REPAIRCOSTFILTERCONTAINER",grid:0};n[60]={id:60,fld:"",grid:0};n[61]={id:61,fld:"",grid:0};n[62]={id:62,fld:"LBLREPAIRCOSTFILTER",format:1,grid:0,evt:"e16151_client",ctrltype:"textblock"};n[63]={id:63,fld:"",grid:0};n[64]={id:64,fld:"",grid:0};n[65]={id:65,fld:"",grid:0};n[66]={id:66,lvl:0,type:"decimal",len:8,dec:2,sign:!1,pic:"ZZZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vCREPAIRCOST",gxz:"ZV11cRepairCost",gxold:"OV11cRepairCost",gxvar:"AV11cRepairCost",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV11cRepairCost=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV11cRepairCost=gx.fn.toDecimalValue(n,".",","))},v2c:function(){gx.fn.setDecimalValue("vCREPAIRCOST",gx.O.AV11cRepairCost,2,",")},c2v:function(){this.val()!==undefined&&(gx.O.AV11cRepairCost=this.val())},val:function(){return gx.fn.getDecimalValue("vCREPAIRCOST",".",",")},nac:gx.falseFn};n[67]={id:67,fld:"",grid:0};n[68]={id:68,fld:"",grid:0};n[69]={id:69,fld:"TECHNICIANALTERNATEIDFILTERCONTAINER",grid:0};n[70]={id:70,fld:"",grid:0};n[71]={id:71,fld:"",grid:0};n[72]={id:72,fld:"LBLTECHNICIANALTERNATEIDFILTER",format:1,grid:0,evt:"e17151_client",ctrltype:"textblock"};n[73]={id:73,fld:"",grid:0};n[74]={id:74,fld:"",grid:0};n[75]={id:75,fld:"",grid:0};n[76]={id:76,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vCTECHNICIANALTERNATEID",gxz:"ZV12cTechnicianAlternateId",gxold:"OV12cTechnicianAlternateId",gxvar:"AV12cTechnicianAlternateId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV12cTechnicianAlternateId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV12cTechnicianAlternateId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCTECHNICIANALTERNATEID",gx.O.AV12cTechnicianAlternateId,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV12cTechnicianAlternateId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCTECHNICIANALTERNATEID",".")},nac:gx.falseFn};n[77]={id:77,fld:"",grid:0};n[78]={id:78,fld:"GRIDTABLE",grid:0};n[79]={id:79,fld:"",grid:0};n[80]={id:80,fld:"",grid:0};n[81]={id:81,fld:"BTNTOGGLE",grid:0,evt:"e18151_client"};n[82]={id:82,fld:"",grid:0};n[83]={id:83,fld:"",grid:0};n[85]={id:85,lvl:2,type:"bits",len:1024,dec:0,sign:!1,ro:1,isacc:0,grid:84,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vLINKSELECTION",gxz:"ZV5LinkSelection",gxold:"OV5LinkSelection",gxvar:"AV5LinkSelection",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV5LinkSelection=n)},v2z:function(n){n!==undefined&&(gx.O.ZV5LinkSelection=n)},v2c:function(n){gx.fn.setGridMultimediaValue("vLINKSELECTION",n||gx.fn.currentGridRowImpl(84),gx.O.AV5LinkSelection,gx.O.AV17Linkselection_GXI)},c2v:function(n){gx.O.AV17Linkselection_GXI=this.val_GXI();this.val(n)!==undefined&&(gx.O.AV5LinkSelection=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vLINKSELECTION",n||gx.fn.currentGridRowImpl(84))},val_GXI:function(n){return gx.fn.getGridControlValue("vLINKSELECTION_GXI",n||gx.fn.currentGridRowImpl(84))},gxvar_GXI:"AV17Linkselection_GXI",nac:gx.falseFn};n[86]={id:86,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:84,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"REPAIRID",gxz:"Z27RepairId",gxold:"O27RepairId",gxvar:"A27RepairId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"number",v2v:function(n){n!==undefined&&(gx.O.A27RepairId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z27RepairId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("REPAIRID",n||gx.fn.currentGridRowImpl(84),gx.O.A27RepairId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A27RepairId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("REPAIRID",n||gx.fn.currentGridRowImpl(84),".")},nac:gx.falseFn};n[87]={id:87,lvl:2,type:"date",len:8,dec:0,sign:!1,ro:1,isacc:0,grid:84,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"REPAIRBEGINDATE",gxz:"Z28RepairBeginDate",gxold:"O28RepairBeginDate",gxvar:"A28RepairBeginDate",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/99",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A28RepairBeginDate=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z28RepairBeginDate=gx.fn.toDatetimeValue(n))},v2c:function(n){gx.fn.setGridControlValue("REPAIRBEGINDATE",n||gx.fn.currentGridRowImpl(84),gx.O.A28RepairBeginDate,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A28RepairBeginDate=gx.fn.toDatetimeValue(this.val(n)))},val:function(n){return gx.fn.getGridDateTimeValue("REPAIRBEGINDATE",n||gx.fn.currentGridRowImpl(84))},nac:gx.falseFn};n[88]={id:88,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:84,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"REPAIRDAYS",gxz:"Z29RepairDays",gxold:"O29RepairDays",gxvar:"A29RepairDays",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"number",v2v:function(n){n!==undefined&&(gx.O.A29RepairDays=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z29RepairDays=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("REPAIRDAYS",n||gx.fn.currentGridRowImpl(84),gx.O.A29RepairDays,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A29RepairDays=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("REPAIRDAYS",n||gx.fn.currentGridRowImpl(84),".")},nac:gx.falseFn};n[89]={id:89,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:84,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"GAMEID",gxz:"Z17GameId",gxold:"O17GameId",gxvar:"A17GameId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"number",v2v:function(n){n!==undefined&&(gx.O.A17GameId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z17GameId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("GAMEID",n||gx.fn.currentGridRowImpl(84),gx.O.A17GameId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A17GameId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("GAMEID",n||gx.fn.currentGridRowImpl(84),".")},nac:gx.falseFn};n[90]={id:90,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:84,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TECHNICIANID",gxz:"Z30TechnicianId",gxold:"O30TechnicianId",gxvar:"A30TechnicianId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"number",v2v:function(n){n!==undefined&&(gx.O.A30TechnicianId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z30TechnicianId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("TECHNICIANID",n||gx.fn.currentGridRowImpl(84),gx.O.A30TechnicianId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A30TechnicianId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("TECHNICIANID",n||gx.fn.currentGridRowImpl(84),".")},nac:gx.falseFn};n[91]={id:91,lvl:2,type:"decimal",len:8,dec:2,sign:!1,pic:"ZZZZ9.99",ro:1,isacc:0,grid:84,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"REPAIRCOST",gxz:"Z34RepairCost",gxold:"O34RepairCost",gxvar:"A34RepairCost",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A34RepairCost=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.Z34RepairCost=gx.fn.toDecimalValue(n,".",","))},v2c:function(n){gx.fn.setGridDecimalValue("REPAIRCOST",n||gx.fn.currentGridRowImpl(84),gx.O.A34RepairCost,2,",");typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A34RepairCost=this.val(n))},val:function(n){return gx.fn.getGridDecimalValue("REPAIRCOST",n||gx.fn.currentGridRowImpl(84),".",",")},nac:gx.falseFn};n[92]={id:92,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:84,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TECHNICIANALTERNATEID",gxz:"Z35TechnicianAlternateId",gxold:"O35TechnicianAlternateId",gxvar:"A35TechnicianAlternateId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"number",v2v:function(n){n!==undefined&&(gx.O.A35TechnicianAlternateId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z35TechnicianAlternateId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("TECHNICIANALTERNATEID",n||gx.fn.currentGridRowImpl(84),gx.O.A35TechnicianAlternateId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A35TechnicianAlternateId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("TECHNICIANALTERNATEID",n||gx.fn.currentGridRowImpl(84),".")},nac:gx.falseFn};n[93]={id:93,fld:"",grid:0};n[94]={id:94,fld:"",grid:0};n[95]={id:95,fld:"BTN_CANCEL",grid:0,evt:"e22151_client"};this.AV6cRepairId=0;this.ZV6cRepairId=0;this.OV6cRepairId=0;this.AV7cRepairBeginDate=gx.date.nullDate();this.ZV7cRepairBeginDate=gx.date.nullDate();this.OV7cRepairBeginDate=gx.date.nullDate();this.AV8cRepairDays=0;this.ZV8cRepairDays=0;this.OV8cRepairDays=0;this.AV9cGameId=0;this.ZV9cGameId=0;this.OV9cGameId=0;this.AV10cTechnicianId=0;this.ZV10cTechnicianId=0;this.OV10cTechnicianId=0;this.AV11cRepairCost=0;this.ZV11cRepairCost=0;this.OV11cRepairCost=0;this.AV12cTechnicianAlternateId=0;this.ZV12cTechnicianAlternateId=0;this.OV12cTechnicianAlternateId=0;this.ZV5LinkSelection="";this.OV5LinkSelection="";this.Z27RepairId=0;this.O27RepairId=0;this.Z28RepairBeginDate=gx.date.nullDate();this.O28RepairBeginDate=gx.date.nullDate();this.Z29RepairDays=0;this.O29RepairDays=0;this.Z17GameId=0;this.O17GameId=0;this.Z30TechnicianId=0;this.O30TechnicianId=0;this.Z34RepairCost=0;this.O34RepairCost=0;this.Z35TechnicianAlternateId=0;this.O35TechnicianAlternateId=0;this.AV6cRepairId=0;this.AV7cRepairBeginDate=gx.date.nullDate();this.AV8cRepairDays=0;this.AV9cGameId=0;this.AV10cTechnicianId=0;this.AV11cRepairCost=0;this.AV12cTechnicianAlternateId=0;this.AV13pRepairId=0;this.AV5LinkSelection="";this.A27RepairId=0;this.A28RepairBeginDate=gx.date.nullDate();this.A29RepairDays=0;this.A17GameId=0;this.A30TechnicianId=0;this.A34RepairCost=0;this.A35TechnicianAlternateId=0;this.Events={e21152_client:["ENTER",!0],e22151_client:["CANCEL",!0],e18151_client:["'TOGGLE'",!1],e11151_client:["LBLREPAIRIDFILTER.CLICK",!1],e12151_client:["LBLREPAIRBEGINDATEFILTER.CLICK",!1],e13151_client:["LBLREPAIRDAYSFILTER.CLICK",!1],e14151_client:["LBLGAMEIDFILTER.CLICK",!1],e15151_client:["LBLTECHNICIANIDFILTER.CLICK",!1],e16151_client:["LBLREPAIRCOSTFILTER.CLICK",!1],e17151_client:["LBLTECHNICIANALTERNATEIDFILTER.CLICK",!1]};this.EvtParms.REFRESH=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cRepairId",fld:"vCREPAIRID",pic:"ZZZ9"},{av:"AV7cRepairBeginDate",fld:"vCREPAIRBEGINDATE",pic:""},{av:"AV8cRepairDays",fld:"vCREPAIRDAYS",pic:"ZZZ9"},{av:"AV9cGameId",fld:"vCGAMEID",pic:"ZZZ9"},{av:"AV10cTechnicianId",fld:"vCTECHNICIANID",pic:"ZZZ9"},{av:"AV11cRepairCost",fld:"vCREPAIRCOST",pic:"ZZZZ9.99"},{av:"AV12cTechnicianAlternateId",fld:"vCTECHNICIANALTERNATEID",pic:"ZZZ9"}],[]];this.EvtParms.START=[[],[{ctrl:"FORM",prop:"Caption"}]];this.EvtParms["'TOGGLE'"]=[[{av:'gx.fn.getCtrlProperty("ADVANCEDCONTAINER","Class")',ctrl:"ADVANCEDCONTAINER",prop:"Class"},{ctrl:"BTNTOGGLE",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("ADVANCEDCONTAINER","Class")',ctrl:"ADVANCEDCONTAINER",prop:"Class"},{ctrl:"BTNTOGGLE",prop:"Class"}]];this.EvtParms["LBLREPAIRIDFILTER.CLICK"]=[[{av:'gx.fn.getCtrlProperty("REPAIRIDFILTERCONTAINER","Class")',ctrl:"REPAIRIDFILTERCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("REPAIRIDFILTERCONTAINER","Class")',ctrl:"REPAIRIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCREPAIRID","Visible")',ctrl:"vCREPAIRID",prop:"Visible"}]];this.EvtParms["LBLREPAIRBEGINDATEFILTER.CLICK"]=[[{av:'gx.fn.getCtrlProperty("REPAIRBEGINDATEFILTERCONTAINER","Class")',ctrl:"REPAIRBEGINDATEFILTERCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("REPAIRBEGINDATEFILTERCONTAINER","Class")',ctrl:"REPAIRBEGINDATEFILTERCONTAINER",prop:"Class"}]];this.EvtParms["LBLREPAIRDAYSFILTER.CLICK"]=[[{av:'gx.fn.getCtrlProperty("REPAIRDAYSFILTERCONTAINER","Class")',ctrl:"REPAIRDAYSFILTERCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("REPAIRDAYSFILTERCONTAINER","Class")',ctrl:"REPAIRDAYSFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCREPAIRDAYS","Visible")',ctrl:"vCREPAIRDAYS",prop:"Visible"}]];this.EvtParms["LBLGAMEIDFILTER.CLICK"]=[[{av:'gx.fn.getCtrlProperty("GAMEIDFILTERCONTAINER","Class")',ctrl:"GAMEIDFILTERCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("GAMEIDFILTERCONTAINER","Class")',ctrl:"GAMEIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCGAMEID","Visible")',ctrl:"vCGAMEID",prop:"Visible"}]];this.EvtParms["LBLTECHNICIANIDFILTER.CLICK"]=[[{av:'gx.fn.getCtrlProperty("TECHNICIANIDFILTERCONTAINER","Class")',ctrl:"TECHNICIANIDFILTERCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("TECHNICIANIDFILTERCONTAINER","Class")',ctrl:"TECHNICIANIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCTECHNICIANID","Visible")',ctrl:"vCTECHNICIANID",prop:"Visible"}]];this.EvtParms["LBLREPAIRCOSTFILTER.CLICK"]=[[{av:'gx.fn.getCtrlProperty("REPAIRCOSTFILTERCONTAINER","Class")',ctrl:"REPAIRCOSTFILTERCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("REPAIRCOSTFILTERCONTAINER","Class")',ctrl:"REPAIRCOSTFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCREPAIRCOST","Visible")',ctrl:"vCREPAIRCOST",prop:"Visible"}]];this.EvtParms["LBLTECHNICIANALTERNATEIDFILTER.CLICK"]=[[{av:'gx.fn.getCtrlProperty("TECHNICIANALTERNATEIDFILTERCONTAINER","Class")',ctrl:"TECHNICIANALTERNATEIDFILTERCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("TECHNICIANALTERNATEIDFILTERCONTAINER","Class")',ctrl:"TECHNICIANALTERNATEIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCTECHNICIANALTERNATEID","Visible")',ctrl:"vCTECHNICIANALTERNATEID",prop:"Visible"}]];this.EvtParms.LOAD=[[],[{av:"AV5LinkSelection",fld:"vLINKSELECTION",pic:""}]];this.EvtParms.ENTER=[[{av:"A27RepairId",fld:"REPAIRID",pic:"ZZZ9",hsh:!0}],[{av:"AV13pRepairId",fld:"vPREPAIRID",pic:"ZZZ9"}]];this.EvtParms.GRID1_FIRSTPAGE=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cRepairId",fld:"vCREPAIRID",pic:"ZZZ9"},{av:"AV7cRepairBeginDate",fld:"vCREPAIRBEGINDATE",pic:""},{av:"AV8cRepairDays",fld:"vCREPAIRDAYS",pic:"ZZZ9"},{av:"AV9cGameId",fld:"vCGAMEID",pic:"ZZZ9"},{av:"AV10cTechnicianId",fld:"vCTECHNICIANID",pic:"ZZZ9"},{av:"AV11cRepairCost",fld:"vCREPAIRCOST",pic:"ZZZZ9.99"},{av:"AV12cTechnicianAlternateId",fld:"vCTECHNICIANALTERNATEID",pic:"ZZZ9"}],[]];this.EvtParms.GRID1_PREVPAGE=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cRepairId",fld:"vCREPAIRID",pic:"ZZZ9"},{av:"AV7cRepairBeginDate",fld:"vCREPAIRBEGINDATE",pic:""},{av:"AV8cRepairDays",fld:"vCREPAIRDAYS",pic:"ZZZ9"},{av:"AV9cGameId",fld:"vCGAMEID",pic:"ZZZ9"},{av:"AV10cTechnicianId",fld:"vCTECHNICIANID",pic:"ZZZ9"},{av:"AV11cRepairCost",fld:"vCREPAIRCOST",pic:"ZZZZ9.99"},{av:"AV12cTechnicianAlternateId",fld:"vCTECHNICIANALTERNATEID",pic:"ZZZ9"}],[]];this.EvtParms.GRID1_NEXTPAGE=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cRepairId",fld:"vCREPAIRID",pic:"ZZZ9"},{av:"AV7cRepairBeginDate",fld:"vCREPAIRBEGINDATE",pic:""},{av:"AV8cRepairDays",fld:"vCREPAIRDAYS",pic:"ZZZ9"},{av:"AV9cGameId",fld:"vCGAMEID",pic:"ZZZ9"},{av:"AV10cTechnicianId",fld:"vCTECHNICIANID",pic:"ZZZ9"},{av:"AV11cRepairCost",fld:"vCREPAIRCOST",pic:"ZZZZ9.99"},{av:"AV12cTechnicianAlternateId",fld:"vCTECHNICIANALTERNATEID",pic:"ZZZ9"}],[]];this.EvtParms.GRID1_LASTPAGE=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cRepairId",fld:"vCREPAIRID",pic:"ZZZ9"},{av:"AV7cRepairBeginDate",fld:"vCREPAIRBEGINDATE",pic:""},{av:"AV8cRepairDays",fld:"vCREPAIRDAYS",pic:"ZZZ9"},{av:"AV9cGameId",fld:"vCGAMEID",pic:"ZZZ9"},{av:"AV10cTechnicianId",fld:"vCTECHNICIANID",pic:"ZZZ9"},{av:"AV11cRepairCost",fld:"vCREPAIRCOST",pic:"ZZZZ9.99"},{av:"AV12cTechnicianAlternateId",fld:"vCTECHNICIANALTERNATEID",pic:"ZZZ9"}],[]];this.EvtParms.VALIDV_CREPAIRBEGINDATE=[[],[]];this.setVCMap("AV13pRepairId","vPREPAIRID",0,"int",4,0);t.addRefreshingParm({rfrProp:"Rows",gxGrid:"Grid1"});t.addRefreshingVar(this.GXValidFnc[16]);t.addRefreshingVar(this.GXValidFnc[26]);t.addRefreshingVar(this.GXValidFnc[36]);t.addRefreshingVar(this.GXValidFnc[46]);t.addRefreshingVar(this.GXValidFnc[56]);t.addRefreshingVar(this.GXValidFnc[66]);t.addRefreshingVar(this.GXValidFnc[76]);t.addRefreshingParm(this.GXValidFnc[16]);t.addRefreshingParm(this.GXValidFnc[26]);t.addRefreshingParm(this.GXValidFnc[36]);t.addRefreshingParm(this.GXValidFnc[46]);t.addRefreshingParm(this.GXValidFnc[56]);t.addRefreshingParm(this.GXValidFnc[66]);t.addRefreshingParm(this.GXValidFnc[76]);this.Initialize()});gx.wi(function(){gx.createParentObj(this.gx0080)})