package reivax.norac.samplewebbapp.model;

import reivax.norac.samplewebbapp.xml.DbModelParser;

/**
 * Created by xavier caron on 22/01/2015.
 */
public class DbModelBuilder {

    private DbModelBuilder(){}

    private static final DbModelBuilder instance = new DbModelBuilder();

    public static DbModelBuilder getInstance(){ return instance; }

    public DbModel build(){
        DbModelParser parser = new DbModelParser();
        return parser.parse(getClass().getClassLoader().getResource("db/dbAsXML.xml"));
    }
}
