package com.koshake1.myfirsttest

import junit.framework.Assert.assertTrue
import org.junit.Assert
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        Assert.assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail(null))
    }

    @Test
    fun emailValidator_SpacesEmail_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("     "))
    }

    @Test
    fun emailValidator_IncorrectSubDomain_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("name@email.com,uk"))
    }

    @Test
    fun emailValidator_NoCommertialAt_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("name.email.com"))
    }
}