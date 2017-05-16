package esame;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ArchivioTest {

	@Test
	public void testarchiviCreatiIl_ConDocumento() {
		
		Documento d = new Documento("single", 1, "01", new PermessoAccesso("permesso"));
		List<Archivio> list = d.archiviCreatiIl("01");
		assertSame(d, list.get(0));
	}

}
