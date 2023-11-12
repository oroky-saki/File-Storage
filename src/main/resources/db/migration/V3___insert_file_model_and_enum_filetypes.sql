CREATE TYPE doc_type AS ENUM(
    'pdf',
    'doc',
    'docx',
    'ppt'
    'pptx',
    'txt',
    'xls',
    'xlsx'
);

CREATE TABLE IF NOT EXISTS files(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    file_type doc_type,
    file_size BIGINT,
    upload TIMESTAMP WITHOUT TIME ZONE,
    edited TIMESTAMP WITHOUT TIME ZONE,
    path VARCHAR(255),
    user_id BIGINT NOT NULL REFERENCES users(id)
)