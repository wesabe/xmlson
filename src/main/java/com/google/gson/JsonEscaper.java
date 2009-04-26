package com.google.gson;

/**
 * Gson 1.3 has a bug with escaping JSON strings. This exposes their
 * Escaper class so we can handle it ourselves.
 * 
 * @author coda
 * @see <a href="http://code.google.com/p/google-gson/issues/detail?id=107">Gson Bug #107</a>
 * @deprecated Get rid of this class and use Gson 1.4
 */
@Deprecated
public class JsonEscaper extends Escaper {
	public JsonEscaper(boolean escapeHtmlCharacters) {
		super(escapeHtmlCharacters);
	}
}
