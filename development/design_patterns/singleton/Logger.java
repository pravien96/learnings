//Singleton Example


//Bill Pugh Singleton
class FileLogger {

	private FileLogger(){}

	private class InstanceHolder {
		private static FileLogger fileLogger = new FileLogger();
	} 

	public static FileLogger getInstance(){
		return InstanceHolder.fileLogger;
	}

	public void log(String content) {
		System.out.println("File : " + content);
	}
}

//Normal Singleton
class JournalLogger {

	private static JournalLogger journalLogger = null;

	private JournalLogger(){}

	public static JournalLogger getInstance(){

		if(journalLogger == null) {
			synchronized(JournalLogger.class) {
				if(journalLogger == null) {
					journalLogger = new JournalLogger();
				}
			
			}
		}
		return journalLogger;
	}

	public void log(String content) {
		System.out.println("Journal : " + content);
	}
}





public class Logger {
	public static void main(String args[]) {
		FileLogger fileLogger = FileLogger.getInstance();
		JournalLogger journalLogger = JournalLogger.getInstance();
		fileLogger.log("Hello");
		journalLogger.log("Hello");
	}
}