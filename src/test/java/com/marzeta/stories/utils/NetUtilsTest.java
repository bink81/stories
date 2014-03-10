package com.marzeta.stories.utils;

import junit.framework.Assert;

import org.junit.Test;

public class NetUtilsTest {
	private static final String ROOT = "https://mail.google.com";
	private static final String EXPECTED_WITHOUT_SLASH = ROOT + "/mail";
	private static final String EXPECTED_WITH_SLASH = EXPECTED_WITHOUT_SLASH + "/";

	@Test
	public void testAssembleUrlWithOneParameter() throws Exception {
		String actual = NetUtils.assembleUrl(EXPECTED_WITH_SLASH);

		Assert.assertEquals(EXPECTED_WITH_SLASH, actual);
	}

	@Test
	public void testAssembleUrlWithOneNull() throws Exception {
		String actual = NetUtils.assembleUrl((String) null);
		Assert.assertEquals(null, actual);
	}

	@Test
	public void testAssembleUrlWithOneParameterAndNull() throws Exception {
		String actual = NetUtils.assembleUrl(EXPECTED_WITH_SLASH, null);
		Assert.assertEquals(EXPECTED_WITH_SLASH, actual);
	}

	@Test
	public void testAssembleUrlWithOneParameterAndTwoNull() throws Exception {
		String actual = NetUtils.assembleUrl(EXPECTED_WITH_SLASH, null, null);
		Assert.assertEquals(EXPECTED_WITH_SLASH, actual);
	}

	@Test
	public void testAssembleUrlWithOneParameterAndEmptySpace() throws Exception {
		String actual = NetUtils.assembleUrl(EXPECTED_WITH_SLASH, "");
		Assert.assertEquals(EXPECTED_WITH_SLASH, actual);
	}

	@Test
	public void testAssembleUrlWithOneParameterAndTwoEmptySpaces() throws Exception {
		String actual = NetUtils.assembleUrl(EXPECTED_WITH_SLASH, "", "");
		Assert.assertEquals(EXPECTED_WITH_SLASH, actual);
	}

	@Test
	public void testAssembleUrlWithOneParameterAndSpace() throws Exception {
		String actual = NetUtils.assembleUrl(EXPECTED_WITH_SLASH, " ");
		Assert.assertEquals(EXPECTED_WITH_SLASH, actual);
	}

	@Test
	public void testAssembleUrlWithOneParameterAndSlash() throws Exception {
		String actual = NetUtils.assembleUrl(EXPECTED_WITH_SLASH, "/");
		Assert.assertEquals(EXPECTED_WITH_SLASH, actual);
	}

	@Test
	public void testAssembleUrlWithOneParameterAndTwoSlashes() throws Exception {
		String actual = NetUtils.assembleUrl(EXPECTED_WITH_SLASH, "/", "/");
		Assert.assertEquals(EXPECTED_WITH_SLASH, actual);
	}

	@Test
	public void testAssembleUrlWithOneParameterWithoutSlash() throws Exception {
		String actual = NetUtils.assembleUrl(EXPECTED_WITH_SLASH);
		Assert.assertEquals(EXPECTED_WITH_SLASH, actual);
	}

	@Test
	public void testAssembleUrlWithTwoParameters() throws Exception {
		String actual = NetUtils.assembleUrl(ROOT, "mail");
		Assert.assertEquals(EXPECTED_WITHOUT_SLASH, actual);
	}

	@Test
	public void testAssembleUrlWithSecondParameterWithSlashPrefix() throws Exception {
		String actual = NetUtils.assembleUrl(ROOT, "/mail");
		Assert.assertEquals(EXPECTED_WITHOUT_SLASH, actual);
	}

	@Test
	public void testAssembleUrlWithSecondParameterWithSlashPrefixAndSuffix() throws Exception {
		String actual = NetUtils.assembleUrl(ROOT, "/mail/");
		Assert.assertEquals(EXPECTED_WITH_SLASH, actual);

	}

	@Test
	public void testAssembleUrlWithSecondParameterWithSlashSuffix() throws Exception {
		String actual = NetUtils.assembleUrl(ROOT, "mail/");
		Assert.assertEquals(EXPECTED_WITH_SLASH, actual);
	}
}
