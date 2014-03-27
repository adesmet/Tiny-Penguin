package net.tinypenguin.service;

import net.tinypenguin.dto.EntryDto;

import java.util.List;

/**
 * Created by Anthony on 27/03/14.
 */
public interface EntryService {
    List<EntryDto> processEntry(EntryDto entryDto);
    List<EntryDto> getEntriesWithoutSaving(EntryDto entryDto);
}
