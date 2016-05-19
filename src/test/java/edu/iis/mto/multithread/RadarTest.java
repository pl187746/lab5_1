package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Rule;
import org.junit.Test;

import edu.iis.mto.repeat.Repeat;
import edu.iis.mto.repeat.RepeatRule;

public class RadarTest {
	
	@Rule
	public RepeatRule repeatRule = new RepeatRule();
	
	@Test
	@Repeat(times = 1000)
	public void launchPatriotOnceWhenNoticesAScudMissle() {
		PatriotBattery batteryMock = mock(PatriotBattery.class);
		Radar radar = new Radar(batteryMock);
		radar.notice(new Scud());
		verify(batteryMock).launchPatriot();
	}

}
