package com.courseland.clients.file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FilesIdsRequest {

    private List<Long> ids;
}
