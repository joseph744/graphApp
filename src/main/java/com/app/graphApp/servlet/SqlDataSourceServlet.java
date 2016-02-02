package com.app.graphApp.servlet;

import javax.servlet.http.HttpServletRequest;
import com.google.visualization.datasource.Capabilities;
import com.google.visualization.datasource.DataSourceServlet;
import com.google.visualization.datasource.base.DataSourceException;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.query.Query;
import com.google.visualization.datasource.util.SqlDataSourceHelper;
import com.google.visualization.datasource.util.SqlDatabaseDescription;

public class SqlDataSourceServlet extends DataSourceServlet {
	/**
	 * The SQL predefined capabilities set is a special custom set for SQL
	 * databases. This implements most of the data source capabilities more
	 * efficiently.
	 */
	public Capabilities getCapabilities() {
		return Capabilities.SQL;
	}

	public DataTable generateDataTable(Query query, HttpServletRequest request) throws DataSourceException {
		SqlDatabaseDescription dbDescription = new SqlDatabaseDescription(request.getParameter("url"),
				request.getParameter("user"), request.getParameter("password"), request.getParameter("table"));
		return SqlDataSourceHelper.executeQuery(query, dbDescription);
	}

	/**
	 * NOTE: By default, this function returns true, which means that cross
	 * domain requests are rejected. This check is disabled here so examples can
	 * be used directly from the address bar of the browser. Bear in mind that
	 * this exposes your data source to xsrf attacks. If the only use of the
	 * data source url is from your application, that runs on the same domain,
	 * it is better to remain in restricted mode.
	 */
	protected boolean isRestrictedAccessMode() {
		return false;
	}
}
