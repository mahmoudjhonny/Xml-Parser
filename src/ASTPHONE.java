/* Generated By:JJTree: Do not edit this line. ASTPHONE.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTPHONE extends SimpleNode {
  public ASTPHONE(int id) {
    super(id);
  }

  public ASTPHONE(Parse_xml p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(Parse_xmlVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=975b40b229897da921ae41c55e7f84f0 (do not edit this line) */
