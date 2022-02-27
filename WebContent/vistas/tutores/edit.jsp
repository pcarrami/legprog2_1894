<%@page import="com.cibertec.edu.matricula.entidades.Tutor"%>
<%@page import="com.cibertec.edu.matricula.entidades.Departamento"%>
<%@page import="java.util.List"%>
<%@page import="com.cibertec.edu.matricula.entidades.Provincia"%>
<%@ include file="../../template/superior.jsp" %>

	<div class="container-fluid">
		<header>
			<label>TUTORES</label>
		</header>
			<div class="col-lg-8">
				<h3>ACTUALIZAR TUTOR</h3>
				
				<%
					Tutor obj = (Tutor) request.getAttribute("obj");
					List<Provincia> lstProvincias = (List<Provincia>) request.getAttribute("lstProvincias"); 
				%>

			<form action="./tutores" method="post">
				ID: <br>
				<input class="form-control" type="text" name="txt_id_tutor" value="<%=obj.getId_tutor()%>"> <br>
				DNI: <br>
				<input class="form-control" type="text" name="txt_dni" value="<%=obj.getDni()%>"> <br>
				NOMBRE: <br>
				<input class="form-control" type="text" name="txt_nombre" value="<%=obj.getNombre()%>"> <br>
				APE. PATERNO: <br>
				<input class="form-control" type="text" name="txt_papellido" value="<%=obj.getPapellido()%>"> <br>
				APE. MATERNO: <br>
				<input class="form-control" type="text" name="txt_sapellido" value="<%=obj.getSapellido()%>"> <br>
				FEC. NACIMIENTO: <br>
				<input class="form-control" type="text" name="dpt_fnacimiento" id="dpt_fnacimiento" readonly value="<%=obj.getFnacimiento()%>"> <br>
				TELEFONO: <br>
				<input class="form-control" type="text" name="txt_telefono" value="<%=obj.getTelefono()%>"> <br>
				PROVINCIAS: <br>
				<select class="form-control" name="cbo_id_prov">
				<% if(lstProvincias !=null) 
					for(Provincia items:lstProvincias){ 
				%>
					<option value="<%=items.getId_prov()%>" <% if(items.getId_prov()==obj.getId_prov()) { %> selected <%} %>><%=items.getNombre() %></option>
				<%		
					}
				
				%>
				
				</select><br>
				
				<input class= "btn btn-outline-primary" type="submit" name="accion" value="Actualizar">
				<a  class= "btn btn-outline-danger" href="./tutores?accion=listar">Regresar</a> <br>		
			</form>
			</div>
			
	</div>
	<script src="./libs/js/bootstrap-datepicker.min.js"></script>
	<script src="./libs/locales/bootstrap-datepicker.es.min.js"></script>
	<script type = "text/javascript">
		$('#dpt_fnacimiento').datepicker({
			language: "es",
			todayBtn: "linked",
			clearBtn: true,
			format: "yyyy-mm-dd",
			multidate: false
			
		});
	</script>
<%@ include file="../../template/inferior.jsp" %>