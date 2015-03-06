package com.google.cloud.bigquery.samples.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import com.google.cloud.bigquery.samples.SyncQuerySample;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;


/**
 * TODO: Insert description here. (generated by elibixby)
 */
public class SyncQuerySampleTest extends BigquerySampleTest {

  @Test
  public void testSyncQuery() throws IOException{
    ByteArrayOutputStream boas = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(boas);
    SyncQuerySample.run(PROJECT_ID, QUERY, 10000, 5, out);
    out.flush();
    assertThat(boas.size(), is(not(0)));
  }
  
}
