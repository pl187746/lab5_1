package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.Executor;

import org.junit.Test;

public class BetterRadarTest {
	
	@Test
	public void launchPatriotOnceWhenNoticesAScudMissle() {
		PatriotBattery batteryMock = mock(PatriotBattery.class);
		Executor sameThreadExecutor = new Executor() {
			@Override
			public void execute(Runnable command) {
				command.run();
			}
		};
		BetterRadar radar = new BetterRadar(batteryMock, sameThreadExecutor);
		radar.notice(new Scud());
		verify(batteryMock).launchPatriot();
	}

}
