/* Generated By:JJTree: Do not edit this line. ASTID.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTID extends SimpleNode {
  public ASTID(int id) {
    super(id);
  }

  public ASTID(Parse_xml p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(Parse_xmlVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=c5fd1c2f221e49f7fa2e747afad53657 (do not edit this line) */
