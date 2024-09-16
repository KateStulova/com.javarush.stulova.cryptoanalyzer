package test;

import java.cryptoapp.Cryptographer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class CryptographerTest {
    @Test
    void encryptKeyZero() {
        List<Character> textEn = List.of('к', 'а', 'т', 'я', ' ', '?');
        List<Character> expected = List.of('к', 'а', 'т', 'я', ' ', '?');
        int key = 0;
        List<Character> actual = Cryptographer.encrypt(textEn, key);
        assertIterableEquals(expected, actual);
    }

    @Test
    void encryptKeyOne() {
        List<Character> textEn = List.of('к', 'а', 'т', 'я', ' ', '?');
        List<Character> expected = List.of('л', 'б', 'у', '.', 'а', ' ');
        int key = 1;
        List<Character> actual = Cryptographer.encrypt(textEn, key);
        assertIterableEquals(expected, actual);
    }

    @Test
    void encryptKeyMinusOne() {
        List<Character> textEn = List.of('к', 'а', 'т', 'я', ' ', '?');
        List<Character> expected = List.of('и', ' ', 'с', 'э', '?', '!');
        int key = -1;
        List<Character> actual = Cryptographer.encrypt(textEn, key);
        assertIterableEquals(expected, actual);
    }

    @Test
    void encryptKeyForty() {
        List<Character> textEn = List.of('к', 'а', 'т', 'я', ' ', '?');
        List<Character> expected = List.of('к', 'а', 'т', 'я', ' ', '?');
        int key = 40;
        List<Character> actual = Cryptographer.encrypt(textEn, key);
        assertIterableEquals(expected, actual);
    }

    @Test
    void encryptKeyFortyOne() {
        List<Character> textEn = List.of('к', 'а', 'т', 'я', ' ', '?');
        List<Character> expected = List.of('л', 'б', 'у', '.', 'а', ' ');
        int key = 41;
        List<Character> actual = Cryptographer.encrypt(textEn, key);
        assertIterableEquals(expected, actual);
    }

    @Test
    void encryptKeyMinusFortyOne() {
        List<Character> textEn = List.of('к', 'а', 'т', 'я', ' ', '?');
        List<Character> expected = List.of('и', ' ', 'с', 'э', '?', '!');
        int key = -41;
        List<Character> actual = Cryptographer.encrypt(textEn, key);
        assertIterableEquals(expected, actual);
    }

    @Test
    void decryptKeyZero() {
        List<Character> textEn = List.of('к', 'а', 'т', 'я', ' ', '?');
        List<Character> expected = List.of('к', 'а', 'т', 'я', ' ', '?');
        int key = 0;
        List<Character> actual = Cryptographer.decrypt(textEn, key);
        assertIterableEquals(expected, actual);
    }

    @Test
    void decryptKeyOne() {
        List<Character> textEn = List.of('л', 'б', 'у', '.', 'а', ' ');
        List<Character> expected = List.of('к', 'а', 'т', 'я', ' ', '?');
        int key = 1;
        List<Character> actual = Cryptographer.decrypt(textEn, key);
        assertIterableEquals(expected, actual);
    }

    @Test
    void decryptKeyMinusOne() {
        List<Character> textEn = List.of('и', ' ', 'с', 'э', '?', '!');
        List<Character> expected = List.of('к', 'а', 'т', 'я', ' ', '?');
        int key = -1;
        List<Character> actual = Cryptographer.decrypt(textEn, key);
        assertIterableEquals(expected, actual);
    }

    @Test
    void decryptKeyForty() {
        List<Character> textEn = List.of('к', 'а', 'т', 'я', ' ', '?');
        List<Character> expected = List.of('к', 'а', 'т', 'я', ' ', '?');
        int key = 40;
        List<Character> actual = Cryptographer.decrypt(textEn, key);
        assertIterableEquals(expected, actual);
    }

    @Test
    void decryptKeyFortyOne() {
        List<Character> textEn = List.of('л', 'б', 'у', '.', 'а', ' ');
        List<Character> expected = List.of('к', 'а', 'т', 'я', ' ', '?');
        int key = 41;
        List<Character> actual = Cryptographer.decrypt(textEn, key);
        assertIterableEquals(expected, actual);
    }

    @Test
    void decryptKeyMinusFortyOne() {
        List<Character> textEn = List.of('и', ' ', 'с', 'э', '?', '!');
        List<Character> expected = List.of('к', 'а', 'т', 'я', ' ', '?');
        int key = -41;
        List<Character> actual = Cryptographer.decrypt(textEn, key);
        assertIterableEquals(expected, actual);
    }

    @Test
    void encryptWhenSymbolIsAbsent() {
        List<Character> textEn = List.of('К', 'а', 'т', 'я', ' ', '?');
        List<Character> expected = List.of('б', 'у', '.', 'а', ' ');
        int key = 1;
        List<Character> actual = Cryptographer.encrypt(textEn, key);
        assertIterableEquals(expected, actual);
    }
}