public class local_global extends CBaseListener{
    static public boolean SCOPE;
    @Override
    public void enterCompoundStatement(CParser.CompoundStatementContext ctx) {
        SCOPE=true;
        System.out.println("true");

    }

    @Override
    public void exitCompoundStatement(CParser.CompoundStatementContext ctx) {
        SCOPE=false;
        System.out.println("false");

    }
}
