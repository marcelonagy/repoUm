package nagy.com.solr;

import java.io.IOException;

import nagy.com.mtfn.MetaphonePtBr;
import nagy.com.mtfn.MetaphonePtBrFrouxo;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public final class FiltroFonetico extends TokenFilter {
	
	private CharTermAttribute charTermAttr;
			
	protected FiltroFonetico(TokenStream input) {
		super(input);
		this.charTermAttr = addAttribute(CharTermAttribute.class);
	}

	public boolean incrementToken() throws IOException {
		if (!this.input.incrementToken()){
			return false;
		}
		MetaphonePtBr mtfn = new MetaphonePtBr(String.valueOf(charTermAttr));
		charTermAttr.setEmpty();
		charTermAttr.append(mtfn.toString());
		
		return true;
	}

}
