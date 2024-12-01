package service.standardentityprovider;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;

@Path("/provider")
public class ProviderResource {

	@GET
	@Path("/streamingOutput")
	@Produces(MediaType.TEXT_PLAIN) // dönen data'nın tipi
	public StreamingOutput streamingOutput() {
		return new StreamingOutput() {		
			@Override
			public void write(OutputStream output) throws IOException, WebApplicationException {
				String message = "streamOutput is enabled.";
				output.write(message.getBytes());
			}
		};
		
	}
	
	@GET
	@Path("/bytearray")
	@Produces(MediaType.TEXT_PLAIN)
	public byte[] byteArray() {
		return "byteArray is called".getBytes();
		
	}
	
	@GET
	@Path("/stringXMLResponse")
	// @Produces(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_XML)
	public String stringXMLResponse() {
		String message = "<customer><name>Name Surname</name></customer>";
		return message;
	}
	
	@GET
	@Path("/file")
	@Produces(MediaType.APPLICATION_XML)
	public File getFile() {
		File file = new File("/home/oem/Desktop/projects/learning/JAXRS-JAXWS/Lesson3/pom.xml");
		return file;
		
	}
}
