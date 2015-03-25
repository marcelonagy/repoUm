package nagy.com.solr;

import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;

public class FiltroFoneticoFactory extends TokenFilterFactory {
		
	public FiltroFoneticoFactory(Map<String, String> args) {
		super(args);
	}

	public TokenStream create(TokenStream arg0) {
		return new FiltroFonetico(arg0);
	}

}
