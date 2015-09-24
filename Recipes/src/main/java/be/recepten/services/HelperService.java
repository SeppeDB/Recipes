package be.recepten.services;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

public class HelperService {

	// MultipartFile omzetten naar een bytearray
	public byte[] MultipartFileToByteArray(MultipartFile file) {

		byte[] bFile = null;

		try {
			bFile = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bFile;
	}

	// bytearray encoderen en weergeven als String
	public String Base64EncodeToString(byte[] image) {
		Base64.Encoder enc = Base64.getEncoder();

		String encString = enc.encodeToString(image);

		return encString;
	}

}
