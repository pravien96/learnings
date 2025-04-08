interface Document {
	public void writeContent(String content);
}


class PdfDocument implements Document {
	public void writeContent(String content) {
		System.out.println("Content Writen To PDF : " + content);
	}
}

class WordDocument implements Document {
	public void writeContent(String content) {
		System.out.println("Content Writen To Word Document : " + content);
	}
}


class DocumentFactory {
	public static Document getDocument(String type) {
		if(type.equals("pdf")){
			return new PdfDocument();
		} else if(type.equals("word")) {
			return new WordDocument();
		} else {
			System.out.println("No type supported");
			return null;
		}
	}
}



public class DocumentWriter {
	public static void main(String args[]){
		Document document = DocumentFactory.getDocument("pdf");
		document.writeContent("Hello");
		document = DocumentFactory.getDocument("word");
		document.writeContent("Hello");
	}
}