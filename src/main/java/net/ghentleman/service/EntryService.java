package net.ghentleman.service;

import net.ghentleman.dto.EntryDto;

import java.util.List;

/**
 *
 * EXAMPLE CASE:
 *
 * For example if the given entry consists out of:
 * eating apple + drinking wine
 * This method can return an entry doing:
 * eating apple + drinking wine
 * But also an entry doing:
 * eating apple + drinking wine + playing videogame
 * It will not return an entry only doing:
 * eating apple
 *
 * After saving this entry can also be part of the result set, e.g. when searching for an entry who is:
 * eating apple
 * Or even when searching for an entry who is:
 * eating

 * Created by Anthony on 27/03/14.
 */
public interface EntryService {

    /**
     * Find entries doing at least the same thing as the provided entry is doing excluding the provided entry itself.
     * Also store the provided entry so it can be compared to other future entries.
     */
    List<EntryDto> processEntry(EntryDto entryDto);

    /**
     * Find entries doing at least the same thing as the provided entry is doing excluding the provided entry itself.
     * Do not store the provided entry.
     */
    List<EntryDto> getEntriesWithoutSaving(EntryDto entryDto);
}
