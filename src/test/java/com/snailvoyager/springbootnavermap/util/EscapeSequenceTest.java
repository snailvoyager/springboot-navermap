package com.snailvoyager.springbootnavermap.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EscapeSequenceTest {

    @Test
    void test_removeEscapeSequences_whenNewLine() {
        String statement = """
                sdalkfjrjtibncvx;,lkjfopewf
                asl;
                kfj\\dasf;\\\\\\lk"j\\"
                sdalkfjrjtibncvx;,lkjfopewf
                asl;
                kfj\\dasf;\\\\\\lk"j\\"
                sdalkfjrjtibncvx;,lkjfopewf
                asl;
                kfj\\dasf;\\\\\\lk"j\\"
                sdalkfjrjtibncvx;,lkjfopewf
                asl;
                kfj\\dasf;\\\\\\lk"j\\"
                """;
        long before = System.currentTimeMillis();
        assertThat(EscapeSequence.removeEscapeSequences(statement)).isEqualTo("sdalkfjrjtibncvx;,lkjfopewfasl;kfjdasf;lk\\\"j\\\"sdalkfjrjtibncvx;,lkjfopewfasl;kfjdasf;lk\\\"j\\\"sdalkfjrjtibncvx;,lkjfopewfasl;kfjdasf;lk\\\"j\\\"sdalkfjrjtibncvx;,lkjfopewfasl;kfjdasf;lk\\\"j\\\"");
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }

    @Test
    void test_removeEscapeSequencesByPattern_whenNewLine() {
        String statement = """
                sdalkfjrjtibncvx;,lkjfopewf
                asl;
                kfj\\dasf;\\\\\\lk"j\\"
                sdalkfjrjtibncvx;,lkjfopewf
                asl;
                kfj\\dasf;\\\\\\lk"j\\"
                sdalkfjrjtibncvx;,lkjfopewf
                asl;
                kfj\\dasf;\\\\\\lk"j\\"
                sdalkfjrjtibncvx;,lkjfopewf
                asl;
                kfj\\dasf;\\\\\\lk"j\\"
                """;
        long before = System.currentTimeMillis();
        assertThat(EscapeSequence.removeEscapeSequencesByPattern(statement)).isEqualTo("sdalkfjrjtibncvx;,lkjfopewfasl;kfjdasf;lk\\\"j\\\"sdalkfjrjtibncvx;,lkjfopewfasl;kfjdasf;lk\\\"j\\\"sdalkfjrjtibncvx;,lkjfopewfasl;kfjdasf;lk\\\"j\\\"sdalkfjrjtibncvx;,lkjfopewfasl;kfjdasf;lk\\\"j\\\"");
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }

}