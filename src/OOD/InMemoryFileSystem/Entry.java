package OOD.InMemoryFileSystem;

public abstract class Entry {
	public Entry(String name, Directory parent) {
	}

	public boolean delete() {
	}

	public abstract int size();

	public String getFullPath() {
	}

	public void changeName(String n) {
	}

	public String getName() {
	}
}