/*  _____ _
 * |_   _| |_  _ _ ___ ___ _ __  __ _
 *   | | | ' \| '_/ -_) -_) '  \/ _` |_
 *   |_| |_||_|_| \___\___|_|_|_\__,_(_)
 *
 * Threema for Android
 * Copyright (c) 2018-2021 Threema GmbH
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package ch.threema.logging;

import android.util.Log;
import org.slf4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import ch.threema.app.BuildConfig;
import ch.threema.logging.backend.DebugLogFileBackend;
import ch.threema.logging.backend.LogBackend;
import ch.threema.logging.backend.LogcatBackend;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

/**
 * This is where loggers are created and where backends are configured.
 *
 * Do not use this manager directly, instead log through SLF4J! For example:
 *
 *     private static final Logger logger = LoggerFactory.getLogger("ThreemaApplication");
 *     ...
 *     logger.debug("This is a debug log");
 */
public class LoggerManager {

    private static final Map<String, Logger> LOGGER_CACHE = new WeakHashMap<>();

    // Don't allow instantiation
    public LoggerManager() {
        throw new UnsupportedOperationException();
    }

    /**
     *  Return the minimal log level for the logger with the specified name.
     */
    @LogLevel
    private static int getMinLogLevel(String name) {
        if (!ListenerUtil.mutListener.listen(69491)) {
            if (name.startsWith("ch.threema")) {
                return Log.INFO;
            }
        }
        if (!ListenerUtil.mutListener.listen(69492)) {
            if (name.equals("Validation")) {
                return Log.INFO;
            }
        }
        if (!ListenerUtil.mutListener.listen(69494)) {
            if ((ListenerUtil.mutListener.listen(69493) ? (name.startsWith("SaltyRTC.") && name.startsWith("org.saltyrtc")) : (name.startsWith("SaltyRTC.") || name.startsWith("org.saltyrtc")))) {
                return Log.INFO;
            }
        }
        return Log.WARN;
    }

    /**
     *  Return logger with the specified name.
     */
    public static Logger getLogger(String name) {
        Logger logger;
        // Cache lookup
        synchronized (LOGGER_CACHE) {
            logger = LOGGER_CACHE.get(name);
        }
        if (!ListenerUtil.mutListener.listen(69495)) {
            if (logger != null) {
                return logger;
            }
        }
        // Get minimal log level
        int minLogLevel = LoggerManager.getMinLogLevel(name);
        // Initialize backends
        final List<LogBackend> backends = new ArrayList<>();
        if (!ListenerUtil.mutListener.listen(69497)) {
            if (BuildConfig.DEBUG) {
                if (!ListenerUtil.mutListener.listen(69496)) {
                    backends.add(new LogcatBackend(Log.VERBOSE));
                }
            }
        }
        if (!ListenerUtil.mutListener.listen(69498)) {
            backends.add(new DebugLogFileBackend(minLogLevel));
        }
        // Initialize and cache logger
        logger = new ThreemaLogger(name, backends);
        synchronized (LOGGER_CACHE) {
            if (!ListenerUtil.mutListener.listen(69499)) {
                LOGGER_CACHE.put(logger.getName(), logger);
            }
        }
        return logger;
    }
}
