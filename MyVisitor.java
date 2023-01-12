import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MyVisitor implements Parse_xmlVisitor {

	private PrintStream out;
	private int indent = 0;
	ArrayList<String> id = new ArrayList<String>();
	ArrayList<String> ages = new ArrayList<String>();
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<String> phones = new ArrayList<String>();

	public MyVisitor(PrintStream out) {
		this.out = out;
	}

	private String indentString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < indent; ++i)
			sb.append(" ");
		return sb.toString();
	}

	public Object visit(SimpleNode node, Object data) {
		out.println(indentString() + node);
		++indent;
		node.childrenAccept(this, data);
		--indent;
		return data;
	}

	public Object visit(ASTPROGRAM node, Object data) {
		out.println(indentString() + node);
		++indent;
		node.childrenAccept(this, data);
		--indent;
		try {
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "123123");
			Statement stmt = myconn.createStatement();
			for (int i = 0; i < id.size(); i++) {
				String sql = "INSERT INTO student (id,name,age,phone)" + " values(" + "'" + id.get(i) + "'" + "," + "'"
						+ names.get(i) + "'" + "," + "'" + ages.get(i) + "'" + "," + "'" + phones.get(i) + "'" + ")";
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	public Object visit(ASTOPENTAG node, Object data) {
		out.println(indentString() + node);
		++indent;
		node.childrenAccept(this, data);
		--indent;
		return data;
	}

	public Object visit(ASTCLOSENTAG node, Object data) {
		out.println(indentString() + node);
		++indent;
		node.childrenAccept(this, data);
		--indent;
		return data;
	}

	public Object visit(ASTE node, Object data) {
		out.println(indentString() + node);
		++indent;
		node.childrenAccept(this, data);
		--indent;
		return data;
	}

	public Object visit(ASTID node, Object data) {
		out.println(indentString() + node + " = " + node.jjtGetValue());
		++indent;
		node.childrenAccept(this, data);
		--indent;
		return data;
	}

	public Object visit(ASTPHONE node, Object data) {
		out.println(indentString() + node + " = " + node.jjtGetValue());
		phones.add(String.valueOf(node.jjtGetValue()));
		++indent;
		node.childrenAccept(this, data);
		--indent;
		return data;
	}

	public Object visit(ASTName node, Object data) {
		out.println(indentString() + node + " = " + node.jjtGetValue());
		names.add(String.valueOf(node.jjtGetValue()));
		++indent;
		node.childrenAccept(this, data);
		--indent;
		return data;
	}

	public Object visit(ASTIDNUM node, Object data) {
		out.println(indentString() + node + " = " + node.jjtGetValue());
		id.add(String.valueOf(node.jjtGetValue()));
		++indent;
		node.childrenAccept(this, data);
		--indent;
		return data;
	}

	public Object visit(ASTAGENUM node, Object data) {
		out.println(indentString() + node + " = " + node.jjtGetValue());
		ages.add(String.valueOf(node.jjtGetValue()));
		++indent;
		node.childrenAccept(this, data);
		--indent;
		return data;
	}

	public Object visit(ASTOPENTAGATTR node, Object data) {
		out.println(indentString() + node);
		++indent;
		node.childrenAccept(this, data);
		--indent;
		return data;
	}

	public Object visit(ASTCLOSTAGATTR node, Object data) {
		out.println(indentString() + node);
		++indent;
		node.childrenAccept(this, data);
		--indent;
		return data;
	}
}