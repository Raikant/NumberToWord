package maven;

import java.io.IOException;

public class DllMain {

	public static void main(String[] args) throws IOException {
		try {
			System.loadLibrary("OTAClient");
			System.out.println("DLL loaded");
		} catch (UnsatisfiedLinkError e) {
			System.err.println("Native code library failed to load.\n" + e);
			System.exit(1);
		}
	}
}