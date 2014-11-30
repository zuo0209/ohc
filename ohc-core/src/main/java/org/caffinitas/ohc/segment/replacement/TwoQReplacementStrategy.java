/*
 *      Copyright (C) 2014 Robert Stupp, Koeln, Germany, robert-stupp.de
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.caffinitas.ohc.segment.replacement;

import org.caffinitas.ohc.segment.HashEntries;

public final class TwoQReplacementStrategy implements ReplacementStrategy
{
    public void entryUsed(long hashEntryAdr)
    {
        HashEntries.setReplacement0(hashEntryAdr, HashEntries.getReplacement0(hashEntryAdr) + 1);
    }

    public void entryReplaced(long oldHashEntryAdr, long hashEntryAdr)
    {
        HashEntries.setReplacement0(hashEntryAdr, HashEntries.getReplacement0(hashEntryAdr) + 1);
    }

    public void entryRemoved(long hashEntryAdr)
    {
        HashEntries.setReplacement0(hashEntryAdr, 0L);
    }

    public long cleanUp(long recycleGoal, ReplacementCallback cb)
    {
        throw new UnsupportedOperationException();
    }
}